
import java.util.Scanner;

public class l {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int max=a;
        if (b>max){
            max=b;
        }
        if (c>max){
            max=c;
        }
        System.out.println("Max is " + max);
    }
}
