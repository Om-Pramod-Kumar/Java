public class floor {
    public static void main(String[] args) {
        int[] arr = {12,14,15,55,66,76,86};
        int target = 56;
        int ans = floor(arr, target);
        System.out.println(ans);
    }

    static int floor(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end - start)/2;

            if (target < arr[mid]){
                end = mid -1;
            }
            else if (target > arr[mid]){
                start = mid +1;
            }
            else{
                return mid;
            }
        }
        return end;
    }
}
