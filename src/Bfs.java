import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
}
