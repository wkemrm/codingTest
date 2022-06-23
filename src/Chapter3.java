import java.util.Arrays;
import java.util.Collections;

public class Chapter3 {
    // 두 배열 합치기 -> 투포인트로 안푼것 퀵정렬로 해도 O(nlogn)
    public int[] solution1(int n, int[] nArray, int m, int[] mArray) {
        int[] answer = new int[n + m];
        int count = 0;

        for (int i = 0 ; i < nArray.length ; i++) {
            answer[count] = nArray[i];
            count++;
        }

        for (int i = 0; i < mArray.length ; i++) {
            answer[count] = mArray[i];
            count++;
        }

        Arrays.sort(answer);

        return answer;
    }

    // 두 배열 합치기 -> 투포인트로 풀었을 때 O(n)
    public int[] solution2(int n, int[] nArray, int m , int[] mArray) {
        int p1 = 0;
        int p2 = 0;
        int[] answer = new int[n + m];
        int i = 0;

        while(p1 < n && p2 < m) {
            if (nArray[p1] < mArray[p2]) {
                answer[i] = nArray[p1];
                p1++;
            } else {
                answer[i] = mArray[p2];
                p2++;
            }
            i++;
        }

        while(p1 < n) {
            answer[i] = nArray[p1];
            p1++;
            i++;
        }

        while(p2 < m) {
            answer[i] = nArray[p2];
            p1++;
            i++;
        }

        return answer;
    }
}
