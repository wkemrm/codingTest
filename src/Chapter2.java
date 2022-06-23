import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    // 피보나치 수열
    public int[] solution5(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2 ; i < n ; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }

    // 소수(에라토스테네스 체) -> 안좋은 방법인듯
    public int solution6(int n) {
        int[] array = new int[n + 1];
        for (int i = 0 ; i < n ; i++) {
            array[i] = i;
        }
        array[1] = 0;
        for (int i = 2 ; i < array.length ; i++) {
            for (int j = i + i ; j < array.length ; j = j + i) {
                array[j] = 0;
            }
        }
        int count = 0;
        for (int i : array) {
            if (i != 0) {
                count++;
            }
        }

        return count;
    }

    // 소수 에스토스테네스 체 -> 이게 맞는듯
    public int solution7(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for(int i = 0 ; i <= n ; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i ; j <= n ; j+=i) {
                    ch[j] = 1;
                }
            }
        }
        
        return answer;
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2 ; i < num ; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    // 뒤집은 소수 -> 못풀었음
    public ArrayList<Integer> solution8(int n, int[] array) {
       ArrayList<Integer> answer = new ArrayList<>();

       for (int i = 0 ; i < array.length ; i++) {
           int tmp = array[i];
           int res = 0;
           while (tmp > 0) {
               int t = tmp % 10;
               res = res * 10 + t;
               tmp = tmp / 10;
           }
            if (isPrime(res)) {
                answer.add(res);
            }
       }

        return answer;
    }

    public int solution9(int n, int[] array) {
        int answer = 0;
        int score = 0;
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] == 1) {
                score++;
                answer += score;
            } else if (array[i] == 0) {
                score = 0;
            }
        }

        return answer;
    }
    
    // 등수 구하기 -> 못풀었음
    public int[] solution10(int n, int[] array) {
        int rank = 1;
        int[] answer = new int[n];

        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < array.length ; j++) {
                if (array[i] < array[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
            rank = 1;
        }
        return answer;
    }

    // 격자판 최대합
    public int solution11(int n, int[][] array) {
        int widthMax = 0;
        int verticalMax = 0;
        int diagonalMax = 0;
        for (int i = 0 ; i < n ; i++) {
            int width = 0;
            int vertical = 0;
            for (int j = 0 ; j < n ; j++) {
                width+= array[i][j];
                vertical += array[j][i];
            }
            if (widthMax < width) {
                widthMax = width;
            }
            if (verticalMax < vertical) {
                verticalMax = vertical;
            }
        }

        for (int i = 0 ; i < n ; i++) {
            diagonalMax += array[i][i];
        }

        int diagonal = 0;

        for (int i = 0 ; i < n ; i++) {
            diagonal += array[i][n - 1 - i];
        }

        diagonalMax = Math.max(diagonalMax, diagonal);

        return Math.max(diagonalMax,Math.max(widthMax , verticalMax));
    }

    // 봉우리
    public int solution12(int n, int[][] array) {
        int [][] map = new int[n + 2][n + 2];

        for (int i = 1 ; i < map.length - 1 ; i++) {
            for (int j = 1 ; j < map.length - 1 ; j++) {
                map[i][j] = array[i - 1][j - 1];
            }
        }
        int answer = 0;
        for (int i = 1 ; i < map.length - 1 ; i++) {
            for (int j = 1 ; j < map.length - 1 ; j++) {
                if (map[i - 1][j] < map[i][j] && map[i + 1][j] < map[i][j] && map[i][j - 1] < map[i][j] && map[i][j + 1] < map[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 봉우리 dx dy 쓰는 버전 -> 이렇게 하면 8방향 추가 되더라도 dx, dy만 추가해도 된다.
    public int solution13(int n, int[][] array) {
        int[] dx = {-1, 0, 1 , 0};
        int[] dy = {0, 1 , 0, -1};

        int answer = 0;

        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < array[i].length ; j++) {
                boolean flag = true;
                for (int k = 0 ; k < 4 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && array[nx][ny] >= array[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }
    
    // 임시반장 정하기 -> 많이 틀렸음 다시 봐야함
    public int solution14(int n, int[][] array) {
        int min = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 1 ; i < array.length ; i++) {
            int cnt = 0;
            for (int j = 1 ; j < array.length ; j++) {
                for (int k = 1 ; k < 6 ; k++) {
                    if (array[i][k] == array[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (min < cnt) {
                min = cnt;
                answer = i;
            }
        }

        return answer;
    }
    
    // 멘토링 -> 4중 for문 다시 풀어봐야함 못풀었음
    public int solution15(int n, int m, int[][] array) {
        int answer = 0;

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                int cnt = 0;
                for (int k = 0 ; k < m ; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int s = 0 ; s < n ; s++) {
                        if (array[k][s] == i) {
                            pi = s;
                        }
                        if (array[k][s] == j) {
                            pj = s;
                        }
                    }
                    if (pi < pj) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
