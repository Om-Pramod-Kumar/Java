
import java.util.Scanner;

public class fibo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Number:");
        int n = in.nextInt();
        int a = 0;
        int b = 1;
        System.out.print(a+",");
        for (int i = 1; i < n; i++) {
            int temp = a;
            a = b;
            b = temp+a;
            System.out.print(a+ ",");
        }



    }
}
