import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        Chapter4 c = new Chapter4();

        System.out.println(c.solution2(input1, input2));
        return ;
    }
}

