import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // 이진수
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        for (int i = 0 ; i < t ; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            while (n > 1) {
                list.add(n % 2);
                n = n / 2;
            }
            list.add(n);
            for (int j = 0 ; j < list.size() ; j++) {
                if (list.get(j) == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
