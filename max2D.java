public class max2D {
    public static void main(String[] args) {
        int[][] arr = {
            {23,42,12,34},
            {33,45,25,66},
            {67,43,55}        
    };
    System.out.println(max(arr));
     
    }

    static int max(int[][] arr){

        int max = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for(int anInt : ints){
                if(anInt > max){
                    max = anInt;
                }
            }
        
        }
        return max;
    }
}
