import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int[] input2 = new int[input1];
        for (int i = 0 ; i < input1 ; i++) {
            input2[i] = sc.nextInt();
        }
        int input3 = sc.nextInt();
        int[] input4 = new int[input3];
        for (int i = 0 ; i < input3 ; i++) {
            input4[i] = sc.nextInt();
        }



        Chapter3 c = new Chapter3();
        int[] ints = c.solution1(input1, input2, input3, input4);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }


        return;
    }
}

