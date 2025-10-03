public class countdigits {
    public static void main(String[] args) {
    
        int[] nums = {23,122,11,3,1,331,3313};
        System.out.println(find(nums));
    }


    static int find(int[] nums){
        int count = 0;
        for(int num : nums){
            if (even(num)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int num){
        int digits = digits(num);
        return digits % 2 == 0;
    }
    
    static int digits(int num){
        if (num<0){
            num = num *-1;
        }
        return (int)(Math.log10(num)+1);
    }

}
