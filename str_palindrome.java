public class str_palindrome {
    public static void main(String[] args) {
        String str = "Ereeeeere";
        System.out.println(palin(str));
    }
    static boolean palin(String str){
        
        str = str.toLowerCase();
        for (int i = 0; i < str.length()/2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length()-1-i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}
