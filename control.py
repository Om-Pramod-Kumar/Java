import cv2
import mediapipe as mp
import pyautogui
import math
import time
from collections import deque

# Initialize MediaPipe
mp_hands = mp.solutions.hands
mp_drawing = mp.solutions.drawing_utils
hands = mp_hands.Hands(max_num_hands=1, min_detection_confidence=0.7)

# Capture webcam
cap = cv2.VideoCapture(0)

# Screen size
screen_w, screen_h = pyautogui.size()

# Gesture control variables
mouse_smooth = deque(maxlen=5)
gesture_label = ""
last_label_time = 0
last_action_time = 0
cooldown = 1.0
dragging = False
pinch_start_time = 0

def distance(p1, p2):
    return math.hypot(p2[0] - p1[0], p2[1] - p1[1])

while True:
    ret, frame = cap.read()
    if not ret:
        break
    
    frame = cv2.flip(frame, 1)
    h, w, _ = frame.shape
    rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    result = hands.process(rgb)

    if result.multi_hand_landmarks:
        for hand_landmarks in result.multi_hand_landmarks:
            mp_drawing.draw_landmarks(frame, hand_landmarks, mp_hands.HAND_CONNECTIONS)

            lm = hand_landmarks.landmark
            index = (int(lm[8].x * w), int(lm[8].y * h))
            thumb = (int(lm[4].x * w), int(lm[4].y * h))
            middle = (int(lm[12].x * w), int(lm[12].y * h))
            ring = (int(lm[16].x * w), int(lm[16].y * h))
            pinky = (int(lm[20].x * w), int(lm[20].y * h))
            wrist = (int(lm[0].x * w), int(lm[0].y * h))

            # Smooth mouse movement
            mouse_x = int(lm[8].x * screen_w)
            mouse_y = int(lm[8].y * screen_h)
            mouse_smooth.append((mouse_x, mouse_y))
            avg_x = int(sum(p[0] for p in mouse_smooth) / len(mouse_smooth))
            avg_y = int(sum(p[1] for p in mouse_smooth) / len(mouse_smooth))
            pyautogui.moveTo(avg_x, avg_y, duration=0.01)

            now = time.time()

            # ===================== States =====================
            fist = all(pt[1] > wrist[1] for pt in [index, middle, ring, pinky])
            open_palm = all(pt[1] < wrist[1] for pt in [index, middle, ring, pinky])
            pinch_dist = distance(index, thumb)

            # ===================== Drag & Drop =====================
            if pinch_dist < 40:
                if not dragging:
                    if pinch_start_time == 0:
                        pinch_start_time = now
                    elif now - pinch_start_time > 0.5:  # hold >0.5s
                        pyautogui.mouseDown()
                        dragging = True
                        gesture_label = "Drag Start"
                        last_label_time = now
                else:
                    gesture_label = "Dragging"
                    last_label_time = now
            else:
                if dragging:
                    pyautogui.mouseUp()
                    dragging = False
                    gesture_label = "Drop"
                    last_label_time = now
                pinch_start_time = 0

            # ===================== Click & Double Click =====================
            if pinch_dist < 40 and not dragging:  
                if now - last_action_time < 0.4:
                    pyautogui.doubleClick()
                    gesture_label = "Double Click"
                    last_label_time = now
                else:
                    pyautogui.click()
                    gesture_label = "Click"
                    last_label_time = now
                last_action_time = now
                time.sleep(0.3)

            # ===================== Right Click =====================
            elif distance(middle, thumb) < 40 and now - last_action_time > 0.4:
                pyautogui.rightClick()
                gesture_label = "Right Click"
                last_label_time = now
                last_action_time = now
                time.sleep(0.3)

            # ===================== Scroll =====================
            elif abs(index[0] - middle[0]) < 30:
                if index[1] < middle[1]:
                    pyautogui.scroll(80)
                    gesture_label = "Scroll Up"
                else:
                    pyautogui.scroll(-80)
                    gesture_label = "Scroll Down"
                last_label_time = now

            # ===================== Zoom (Index + Middle distance) =====================
            # zoom_dist = distance(index, middle)
            # if zoom_dist > 120 and now - last_action_time > 0.5:
            #     pyautogui.hotkey("ctrl", "+")
            #     gesture_label = "Zoom In"
            #     last_label_time = now
            #     last_action_time = now
            # elif zoom_dist < 40 and now - last_action_time > 0.5:
            #     pyautogui.hotkey("ctrl", "-")
            #     gesture_label = "Zoom Out"
            #     last_label_time = now
            #     last_action_time = now

            # ===================== Swap Windows =====================
            elif index[0] < 50 and now - last_action_time > cooldown:
                pyautogui.hotkey("alt", "tab")
                gesture_label = "Swap Window"
                last_label_time = now
                last_action_time = now

            # ===================== Minimize =====================
            elif fist and now - last_action_time > cooldown:
                pyautogui.hotkey("win", "down")
                gesture_label = "Minimize Window"
                last_label_time = now
                last_action_time = now

            # ===================== Maximize =====================
            # elif open_palm and now - last_action_time > cooldown:
            #     pyautogui.hotkey("win", "up")
            #     gesture_label = "Maximize Window"
            #     last_label_time = now
            #     last_action_time = now

    # ===================== Show Labels =====================
    if gesture_label and time.time() - last_label_time < 1.5:
        cv2.putText(frame, gesture_label, (50, 100),
                    cv2.FONT_HERSHEY_SIMPLEX, 1.5, (0, 255, 0), 3)

    cv2.imshow("Hand Gesture Control", frame)

    if cv2.waitKey(1) & 0xFF == 27:
        break

cap.release()
cv2.destroyAllWindows()
