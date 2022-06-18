import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = Integer.valueOf(sc.next());
        String input2 = sc.next();
        Chapter1 c = new Chapter1();
        String s = c.solution17(input1, input2);

        System.out.println(s);

        return;
    }
}
