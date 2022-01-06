import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Basic {
    // 약수 구하기
    public int problem1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++) {
            if (n % i == 0){
                list.add(i);
            }
        }

        if (k - 1 >= list.size()) {
            return 0;
        }
        return list.get(k - 1);
    }

    // 이진수
    public void problem2(String[] args) {
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
