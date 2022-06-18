import java.util.ArrayList;
import java.util.List;

public class Chapter2 {
    // 큰 수 출력하기
    public int[] solution1(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 보이는 학생
    public int solution2(int n, int[] arr) {
        int answer = 1;
        int size = arr[0];

        for (int i = 1 ; i < arr.length ; i++) {
            if (size < arr[i]) {
                answer++;
                size = arr[i];
            }
        }

        return answer;
    }

    // 가위바위보
    public String[] solution3(int n, int[][] arr) {
        String[] answer = new String[n];
        for (int i = 0 ; i < arr[0].length ; i++) {
            if (arr[0][i] == 1) {
                if (arr[1][i] == 1) {
                    answer[i] = "D";
                } else if (arr[1][i] == 2) {
                    answer[i] = "B";
                } else if (arr[1][i] == 3) {
                    answer[i] = "A";
                }
            } else if (arr[0][i] == 2) {
                if (arr[1][i] == 1) {
                    answer[i] = "A";
                } else if (arr[1][i] == 2) {
                    answer[i] = "D";
                } else if (arr[1][i] == 3) {
                    answer[i] = "B";
                }
            } else if (arr[0][i] == 3) {
                if (arr[1][i] == 1) {
                    answer[i] = "B";
                } else if (arr[1][i] == 2) {
                    answer[i] = "A";
                } else if (arr[1][i] == 3) {
                    answer[i] = "D";
                }
            }
        }
        return answer;
    }
    
    // 가위 바위 보 더 좋은 방법
    public String[] solution4(int n, int[][] arr) {
        String[] answer = new String[n];
        for (int i = 0 ; i < arr[0].length ; i++) {
            if (arr[0][i] == arr[1][i]) {
                answer[i] = "D";
            } else if (arr[0][i] == 1 && arr[1][i] == 3) {
                answer[i] = "A";
            } else if (arr[0][i] == 2 && arr[1][i] == 1) {
                answer[i] = "A";
            } else if (arr[0][i] == 3 && arr[1][i] == 2) {
                answer[i] = "A";
            } else {
                answer[i] = "B";
            }
        }
        return answer;
    }
}
