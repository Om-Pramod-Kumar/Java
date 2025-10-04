public class pattern {
    public static void main(String[] args) {
        p(4);
    }

    static void p31(int n){
        for (int i = 1; i < 2*n; i++) {
            for (int j = n; j >=1; j--) {
                System.out.println(j);
            }
            System.out.println();
        }
    }

    static void p(int n){
        int orig = n;
        n = 2 * n-2;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int e = orig-Math.min(Math.min(i, j), Math.min(n-i, n-j));
                System.out.print(e +" ");
            }
            System.out.println();
        }
    }

    static void p17(int n){
        for (int i = 1; i <= 2*n; i++) {
            int col = i > n ? n-(i-n) : i;
            for (int s = 0; s < n-col; s++) {
                System.out.print("  ");
            }
            for (int j = col; j >= 1; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <= col; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    static void p30(int n){
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s < n-i; s++) {
                System.out.print("  ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void p28(int n){
        for (int i = 0; i < 2*n; i++) {
            int col = i > n ? n-(i-n) : i;
            int sp = n - col;
            for (int s = 0; s < sp; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p5(int n){
        for(int i = 0; i <= 2*n; i++) {
            int col = i > n ? n-(i-n) : i;
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void p3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p2(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
