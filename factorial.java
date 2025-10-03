
import java.util.Scanner;



public class factorial {
    public static void main(String[] args) {
        
        System.out.print("Enter Number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int ans = factorial(n);
        System.out.println("Factorial is : "+ ans);
        
    }
        static int factorial(int n){
        
        int fact = 1;
        for (int i = 1; i <=n; i++) {
            fact = fact*i;
            
        }
        return fact;
        
    }
}
