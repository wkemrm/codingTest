import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            p2++;
            i++;
        }

        return answer;
    }

    
    // 공통 원소 구하기 -> 손코딩 하라고 할수도있음
    public List<Integer> solution3(int n, int[] nArray, int m , int[] mArray) {
        Arrays.sort(nArray);
        Arrays.sort(mArray);
        List<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while(p1 < n && p2 < m) {
            if (nArray[p1] == mArray[p2]) {
                answer.add(nArray[p1]);
                p1++;
                p2++;
            } else if (nArray[p1] < mArray[p2]) {
                p1++;
            } else if (nArray[p1] > mArray[p2]) {
                p2++;
            }
        }

        return answer;
    }


    // 최대 매출 -> 틀렸었음 -> 슬라이딩 윈도우 문제
    public int solution4 (int n, int m, int[] array) {
        int answer = 0;
        int sum = 0;

        for (int j = 0 ; j < m ; j++) {
            answer += array[j];
        }

        sum = answer;

        for (int i = m ; i < n ; i++) {
            sum = sum + array[i] - array[i - m];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    //todo
    // 연속 부분수열 -> 봐도 모르겠음 다시 풀자 -> 다시 풀었는데 또 틀렸음
    public int solution5 (int n, int m, int[] array) {
        int answer = 0;
        int lt = 0;

        int sum = 0;

        for (int rt = 0 ; rt < n ; rt++) {
            sum += array[rt];
            if (sum == m) answer++;

            while(sum >= m) {
                sum -= array[lt];
                lt++;
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    // 연속된 자연수의 합
   public int solution6(int n) {
        int[] array = new int[n];
        for (int i = 1 ; i < n + 1 ; i++){
            array[i - 1] = i;
        }

        int answer = 0;
        int lt = 0;
        int sum = 0;
        for (int rt = 0 ; rt < n ; rt++) {
            sum += array[rt];
            if (lt != rt && sum == n) answer++;

            while(sum >= n) {
                sum -= array[lt];
                lt++;
                if (lt != rt && sum == n) answer++;
            }
        }

        return answer;
    }

    // 최대 길이 연속부분수열 -> 한번에 풀음!!!
    public int solution7(int n, int k, int[] array) {
        int answer = 0;
        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < n ; rt++) {
            if (k == 0 && array[rt] == 0) {
                count = rt - lt;
                rt--;
                while(k == 0) {
                    if (array[lt] == 0) {
                        k++;
                    }
                    lt++;
                }
            } else if (k > 0 && array[rt] == 0) {
                k--;
            }

            answer = Math.max(answer, count);
        }
        answer = Math.max(answer, count);
        return answer;
    }

    // 최대 길이 연속부분수열 -> 강의에서 나오는 방식 훨씬 간결 -> 이방식 기억나는지 다시풀어봐야함
    public int solution8(int n, int k, int[] array) {
        int answer = 0;
        int lt = 0;
        int cnt = 0;
        for (int rt = 0 ; rt < n ; rt++){
            if (array[rt] == 0) cnt++;

            while(k < cnt) {
                if (array[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }
}
