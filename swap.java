
import java.util.Arrays;

public class swap{
    public static void main(String[] args) {
        
        int[] arr = {12,45,22,134,121};
        swap(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr , int index1 , int index2){

        int temp = arr [index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }


}