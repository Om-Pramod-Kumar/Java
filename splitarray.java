public class splitarray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitarray(arr, m));
    }

    static int splitarray(int[] arr, int m){
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = Math.max(start, arr[i]);
            end = end + arr[i];
        }

        while(start < end){
            int mid = start + (end - start)/2;

            int sum = 0;
            int p = 1;
            for (int num : arr){
                if(sum + num > mid){
                    sum = num;
                    p++;

                }
                else{
                    sum = sum + num;
                }
            }

            if(p > m){
                start = mid + 1;

            }
            else{
                end = mid;
            }        
        }

            return end;
    }   
}

