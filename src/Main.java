import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = Integer.parseInt(sc.next());

        int[][] input2 = new int[input1 + 1][6];
        for (int i = 1 ; i < input1 + 1 ; i++) {
            for (int j = 1 ; j < 6 ; j++) {
                input2[i][j] = sc.nextInt();
            }
        }

        Chapter2 c = new Chapter2();
        System.out.println(c.solution14(input1, input2));


        return;
    }
}

