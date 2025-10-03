public class maxwealth {

    public static void main(String[] args) {
        
        int[][] account = {
            {1,2,3},
            {1,3,4}
        };
        int ans = Integer.MIN_VALUE;
        for(int person = 0; person < account.length; person++){
            int sum = 0;
            for(int wealth = 0; wealth < account[person].length; wealth++){
                sum = sum + account[person][wealth];
            }
        
        if (sum > ans){
            ans = sum;
        }
    }
        
    
    System.out.println(ans);
    
    }

}
