import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Implementation {
    // 구현 : 머릿속에 있는 것을 코드로 구현하는것
    // 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제이다.

    // 상하좌우
    public String problem1(int n, String k) {
        int[][] array = new int[n + 1][n + 1];
        int nowX = 1;
        int nowY = 1;
        // R, U, L,D
        int dx[] = {0, -1, 0, 1};
        int dy[] = {1, 0 ,-1 ,0};
        String[] move = {"R", "U", "L", "D"};

        String[] stringArray = k.split(" ");
        List<String> stringsList = new ArrayList<>();

        for (String s : stringArray) {
            stringsList.add(s);
        }

        for (int i = 0 ; i < stringsList.size() ; i++) {
            String direction = stringsList.get(i);
            for (int j = 0 ; j < 4 ; j++) {
                if (direction.equals(move[j])) {
                    if (0 < nowX + dx[j] && nowX + dx[j] <= n && 0 < nowY + dy[j] && nowY + dy[j] <= n) {
                        nowX += dx[j];
                        nowY += dy[j];
                    }
                }
            }
        }
        return Integer.toString(nowX) + " " + Integer.toString(nowY);
    }

    // 시각
    public int problem2(int n) {
        int count = 0;

        for (int i = 0 ; i < n + 1 ; i++) {
            for (int j = 0 ; j < 60 ; j++) {
                for (int k = 0 ; k < 60 ; k++) {
                    if ((Integer.toString(i) + Integer.toString(j) + Integer.toString(k)).contains("3")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // 왕실의 나이트
    public int problem3(String position) {
        char[] y = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        int nx = position.charAt(1) - '0';
        int ny = 0;

        for (int i = 0 ; i < y.length ; i++) {
            if (position.charAt(0) == y[i]) {
                ny = i + 1;
            }
        }

        int count = 0;

        for (int i = 0 ; i < 8 ; i++) {
            if (nx + dx[i] > 0 && nx + dx[i] <= 8 && ny + dy[i] > 0 && ny + dy[i] <= 8) {
                count++;
            }
        }

        return count;
    }

    // 문자열 재정렬
    public String problem4(String s) {
        int su = 0;
        List<Character> list = new ArrayList<>();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) - 'A' < 0) {
                su += s.charAt(i) - '0';
            } else {
                list.add(s.charAt(i));
            }
        }

        Collections.sort(list);

        String result = "";
        for (int i = 0 ; i < list.size() ; i++) {
            result += list.get(i);
        }
        result += su;

        return result;
    }
}
