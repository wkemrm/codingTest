import java.util.ArrayList;
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
}
