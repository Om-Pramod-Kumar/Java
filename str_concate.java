public class str_concate {
    public static void main(String[] args) {
        String aph = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            aph  = aph + ch;
        }
        System.out.println(aph);
    }
}