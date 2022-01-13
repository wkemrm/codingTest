import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    //백준 10798 세로읽기
    public void problem10798() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        try {
            for (int i = 0 ; i < 5 ; i++) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
        }

        String result = "";
        for (int i = 0 ; i < 15; i++) {
            for (int j = 0 ; j < list.size() ; j++) {
                if (list.get(j).length() <= i) {
                    continue;
                }
                result += list.get(j).charAt(i);
            }
        }

        System.out.println("result = " + result);
    }

    //백준 2049 윷놀이
    public void problem2049() {
        // 도 0111 A
        // 개 0011 B
        // 걸 0001 C
        // 윷 0000 D
        // 모 1111 E
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "E");
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] result = new String[3];
        try {
            for (int i = 0 ; i < 3 ; i++) {
                String line = br.readLine();
                int zero = 0;
                for (int j = 0 ; j < line.length(); j++) {
                    if (line.charAt(j) == '0') {
                        zero++;
                    }
                }
                result[i] = map.get(zero);
            }
        } catch (Exception e) {

        }

        for (int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
    }

    //백준 2884 알람 시계
    public void problem2884() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] s = br.readLine().split(" ");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int total = (h * 60) + m;
            if (total < 45) {
                total += (24 * 60);
            }
            total -= 45;
            int nh = total/60;
            int nm = total%60;
            System.out.println(nh + " " + nm);
        } catch (IOException e) {


        }
    }

    //0 CBADEF
    //1 CBDAEF
    //2 CDBEAF

    //0 ALJCRUO
    //1 ALCJRUO
    //2 ACLRJUO
    //3 CALRUJO
}
