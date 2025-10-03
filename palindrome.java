
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        
        System.out.print("Enter Number:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int temp = n;
        int rev = 0;
        while(temp>0){
            int rem = temp % 10;
            temp = temp/10;
            rev = rev * 10 + rem;

            
        }
        if (rev==n){
                System.out.println("Palindrome");
            }
            else{
                System.out.println("Not Palindrome");
            }
    }
}
