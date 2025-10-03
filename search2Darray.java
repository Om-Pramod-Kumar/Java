
import java.util.Arrays;


public class search2Darray{
    public static void main(String[] args) {
        int[][] arr = {
            {23,44,21,44},
            {75,65,79,43},
            {87,76,62,51},
            {45,22}
        };
        int target = 76;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    
    }

    static int[] search(int[][] arr, int target){
        
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col] == target){
                    return new int[] {row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}