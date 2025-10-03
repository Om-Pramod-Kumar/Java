public class armstrong{
    public static void main(String[] args) {

        for (int i = 100; i < 1000 ; i++) {
            armstrong(i);
        }
    }
        static void armstrong(int n){
            int orig = n;
            int sum = 0;


            while(n>0){
                int rem = n % 10;
                n = n/10;
                sum = sum + rem * rem *rem;
            }
            if (sum==orig){
                System.out.print(orig + " ");
            }
        }


    }

