import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = Integer.parseInt(sc.next());
        int[][] input2 = new int[2][input1];

        for (int i = 0 ; i < input1 ; i++) {
            input2[0][i] = Integer.parseInt(sc.next());
        }

        for (int i = 0 ; i < input1 ; i++) {
            input2[1][i] = Integer.parseInt(sc.next());
        }
        Chapter2 c = new Chapter2();
        String[] strings = c.solution3(input1, input2);
        for (String string : strings) {
            System.out.println(string);
        }

        return;
    }
}

