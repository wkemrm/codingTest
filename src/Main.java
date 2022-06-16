import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        Chapter1 c = new Chapter1();
        String s = c.solution8(input1);

        System.out.println(s);

        return;
    }
}
