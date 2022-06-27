import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();

        int[] input3 = new int[input1];

        for (int i = 0 ; i < input1 ; i++) {
            input3[i] = in.nextInt();
        }

        Chapter4 c = new Chapter4();
        List<Integer> integers = c.solution3(input1, input2, input3);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        return ;
    }
}

