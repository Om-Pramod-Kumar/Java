public class firstlast {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,6,7,7,7,8};
        int target = 4;
        int[] ans = searchrange(arr,target);
       
        System.out.println(ans[0] + "," + ans[1]); 
    }

    public static int[] searchrange(int[] nums, int target){

        int[] ans = {-1,-1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);

        return ans;
    }
    public static int search(int[] arr, int target, boolean findStart){

        
        int ans =-1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if (target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                ans = mid;
                if (findStart){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
    