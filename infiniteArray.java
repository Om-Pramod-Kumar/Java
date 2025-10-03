public class infiniteArray{
    public static void main(String[] args) {
        int[] arr = {2,5,7,9,10,19,23,25,45,67,78,88,99};
        int target = 45;
        System.out.println(ans(arr, target));
    }
    ////////////
    static int get(int[] arr, int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;  // beyond bounds → treated as infinity
        }
        return arr[index];
    }
    ////////////
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;

        while(target >get(arr, end)){
            int newstart = end + 1;

            end = end + (end - start + 1) * 2;
            start = newstart;
        }
        return binarysearch(arr, target, start, end);
    }
    static int binarysearch(int[] arr, int target,int start, int end){
        while(start<= end){
            int mid = start + (end-start)/2;

            if (target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
