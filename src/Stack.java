import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stack {
    // TODO: 2022.6.14. 프로그래머스 스택/큐 기능개발 틀렸었음 다시 풀어야함 -> 2022.6.21일에 다시 풀기
    public int[] solution1(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < progresses.length ; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];
            if (remain > 0) {
                day += 1;
            }

            if (!q.isEmpty() && q.peek() < day) {
                answers.add(q.size());
                q.clear();
            }

            q.offer(day);
        }

        answers.add(q.size());

        int[] answer = new int[answers.size()];
        for (int i = 0 ; i < answers.size() ; i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
    
    // TODO: 2022.6.14. 프로그래머스 스택/큐 프린트 틀렸었음 다시 풀어야함 -> 2022.6.21일에 다시 풀기
    public int solution(int[] priorities, int location) {
        // A B C D
        // C D A B
        Queue<Priority> q = new LinkedList();
        for (int i = 0 ; i < priorities.length ; i++) {
            Priority priority = new Priority(i, priorities[i]);

            if (!q.isEmpty() && q.peek().priority < priority.priority) {
                int size = q.size();
                for (int j = 0 ; j < size ; j++) {
                    q.offer(q.peek());
                }
            }

            q.offer(priority);
        }

        int answer = 0;
        for (Priority priority : q) {
            if (location == priority.index) {
                break;
            }
            answer++;
        }


        return answer;
    }

    public class Priority {
        private int index;
        private int priority;

        public Priority(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
