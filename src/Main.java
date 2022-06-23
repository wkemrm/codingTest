import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int[][] input3 = new int[input2][input1];
        for (int i = 0 ; i < input2 ; i++) {
            for (int j = 0 ; j < input1 ; j++) {
                input3[i][j] = sc.nextInt();
            }
        }

        Chapter2 c = new Chapter2();
        System.out.println(c.solution15(input1, input2, input3));


        return;
    }
}

