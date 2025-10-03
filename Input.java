import  java.util.Scanner;
public class Input{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Please enter input: ");
        int rno=input.nextInt();
        System.out.println("Roll No: " + rno);
    }
}