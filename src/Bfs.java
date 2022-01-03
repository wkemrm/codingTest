import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
    // 너비 우선 탐색
    // 큐 자료구조 이용
    boolean[] visited = new boolean[9];
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            System.out.println(x + " ");

            for (int i = 0 ; i < graph.get(x).size() ; i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    //미로탈출
    public int problem1() {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int graph[][] = new int[n + 1][m + 1];
        for (int i = 0 ; i < n; i++) {
            String s1 = sc.nextLine();
            for (int j = 0 ; j < m ; j++) {
                graph[i][j] = s1.charAt(j) - '0';
            }
        }

        return bfsProblem1(0, 0, graph, n, m);
    }

    public int bfsProblem1(int x, int y, int[][] graph, int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (graph[nx][ny] == 0) continue;

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return graph[n - 1][m - 1];
    }
}
