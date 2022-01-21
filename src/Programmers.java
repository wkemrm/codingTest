import java.util.*;
import java.util.Map.Entry;

public class Programmers {
    //프로그래머스 레벨 1 음양 더하기
    public int problem1(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0 ; i < signs.length ; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }

    //프로그래머스 레벨1
    public int problem2(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int [] su = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0 ; i < numbers.length ; i++) {
            su[numbers[i]] = 0;
        }
        for (int i : su) {
            answer += i;
        }
        return answer;
    }

    //프로그래머스 레벨1 체육복
    public int problem3(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] array = new int[n];
        for (int i = 0 ; i < n ; i++) {
            array[i] = 1;
        }
        for (int i = 0 ; i <lost.length ; i++) {
            array[lost[i] - 1]--;
        }
        for (int i = 0 ; i < reserve.length ; i++) {
            array[reserve[i] - 1]++;
        }

        for (int i = 0 ; i < n ; i++) {
            if (array[i] == 2) {
                if (i > 0 && array[i - 1] == 0) {
                    array[i] -= 1;
                    array[i -1] += 1;
                } else if ( i < n - 1 && array[i + 1] == 0) {
                    array[i] -= 1;
                    array[i + 1] += 1;
                }
            }
        }
        for (int i = 0 ; i < n ; i++) {
            if (array[i] > 0) {
                answer += 1;
            }
        }
        return answer;
    }

    //프로그래머스 레벨1 실패율
    public int[] problem4(int N, int[] stages) {
        int[] answer = new int[N];
        int people = stages.length;
        Node[] nodes = new Node[N];


        float[] failPeopleNum = new float[N + 2];
        for (int i = 0 ; i < stages.length; i++) {
            failPeopleNum[stages[i]]++;
        }


        for (int i = 1 ; i <= N ; i++) {
            if(people != 0) {
                float v = failPeopleNum[i] / people;
                nodes[i - 1] = new Node(i, v);
                people -= failPeopleNum[i];
            } else {
                nodes[i - 1] = new Node(i,0);
            }

        }

        Comparator<Node> f = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.getFail() == o2.getFail()) {
                    return Integer.compare(o1.getIndex(), o2.getIndex());
                }
                return -Float.compare(o1.getFail(), o2.getFail());
            }
        };

        Arrays.sort(nodes, f);

        for (int i = 0 ; i < nodes.length ; i++) {
            answer[i] = nodes[i].getIndex();
        }

        return answer;
    }

    class Node {
        private int index;
        private float fail;

        public Node(int index, float fail) {
            this.index = index;
            this.fail = fail;
        }

        public int getIndex() {
            return index;
        }

        public float getFail() {
            return fail;
        }
    }
}
