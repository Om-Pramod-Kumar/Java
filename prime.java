
import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        
        System.out.print("Enter Number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (isPrime(n)){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not");
        }
    }
        static boolean isPrime(int n){
        if (n<=1){
            return false;
            
        }

        for (int i = 2; i * i <= n; i++) {
            if (n%i==0){
                return false;
                
            }
        }
        return true;
       

    }
}
