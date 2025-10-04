import java.util.Arrays;

public class strMethod {
    public static void main(String[] args) {
        String name = "Tilak Verma";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(Arrays.toString(name.split(" ")));
        System.out.println(name.toLowerCase());
        System.out.println(name.indexOf('l'));
        System.out.println("       Hello Byee   ".strip());
        System.out.println(name);
    }
}
