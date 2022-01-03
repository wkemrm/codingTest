import java.util.List;
import java.util.Scanner;

public class Dfs {
    // 깊이 우선 탐색
    // 스택 or 재귀 함수를 이용
    int[][] graph = {{}, {2, 3, 8}, {1, 7}, {1, 4, 5}, {3, 5}, {3, 4}, {7}, {2, 6, 8}, {1, 7}};
    boolean[] visited = new boolean[9];

    // 1 2 7 6 8 3 4 5
    public void dfs(int v) {
        visited[v] = true;
        System.out.println(v);
        for (int i = 0 ; i < graph[v].length ; i++) {
            int y = graph[v][i];
            if (!visited[y]) dfs(y);
        }
    }

    //음료수 얼려 먹기
    public void problem1() {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] graph = new int[x][y];

        for (int i = 0 ; i < x ; i++) {
            String line = sc.nextLine();
            for (int j = 0 ; j < line.length() ; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < x ; i++) {
            for (int j = 0; j < y ; j++) {
                if (dfsProblem1(graph, i, j)) {
                    count++;
                }
            }
        }

    }

    public boolean dfsProblem1(int[][] graph, int x, int y) {
        if (x <= -1 || x >= graph.length || y <= -1 || y >= graph[x].length) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;

            dfsProblem1(graph, x - 1, y);
            dfsProblem1(graph, x + 1, y);
            dfsProblem1(graph, x, y - 1);
            dfsProblem1(graph, x , y + 1);

            return true;
        }
        return false;
    }
}