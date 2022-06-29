import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Chapter5 {
    // 올바른 괄호 => 스택으로 안풀었을때
    public String solution1(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return "NO";
            }
        }

        if (count != 0) {
            return "NO";
        } else {
            return "YES";
        }
    }

    // 올바른 괄호 => 스택으로 풀었을때때
   public String solution2(String s) {
       Stack<Character> stack = new Stack<>();
       for (char c : s.toCharArray()) {
           if (c == '(') {
               stack.push(c);
           } else {
               if (stack.isEmpty()) {
                   return "NO";
               }
               stack.pop();
           }
       }

       if (stack.isEmpty()) {
           return "YES";
       } else {
           return "NO";
       }
    }
    
    // 괄호 문자 제거
    public String solution3(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c : s.toCharArray()) {
            if (c == ')') {
                while(stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        for (Character character : stack) {
            answer += character;
        }
        return answer;
    }
    
    // 크레인 인형뽑기(카카오)
    public int solution4(int n, int[][] board, int m, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0 ; i < moves.length ; i++) {
            int y = moves[i];
            for (int j = 0 ; j < board.length ; j++) {
                if (board[j][y - 1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][y - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][y - 1]);
                    }
                    board[j][y - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    // 후위식 연산
    public int solution5(String s) {
        Stack<Integer> stack = new Stack<>();
        int one = 0;
        int two = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            switch (c){
                case '+':
                    one = stack.pop();
                    two = stack.pop();
                    result = two + one;

                    stack.push(result);
                    break;
                case '-':
                    one = stack.pop();
                    two = stack.pop();
                    result = two - one;
                    stack.push(result);
                    break;
                case '*':
                    one = stack.pop();
                    two = stack.pop();
                    result = two * one;
                    stack.push(result);
                    break;
                case '/':
                    one = stack.pop();
                    two = stack.pop();
                    result = two / one;
                    stack.push(result);
                    break;
                default:
                    stack.push(Character.getNumericValue(c));
                    break;
            }

        }
        return stack.pop();
    }
    
    // 쇠막대기 -> 못풀었음 문제를 생각할때 좀 다양하게 생각할 필요가 있을듯
    public int solution6(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                if (chars[i - 1] == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    answer += 1;
                    stack.pop();
                }

            }
        }
        return answer;
    }
    
    // 공주 구하기
    public int solution7(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            queue.offer(i + 1);
        }

        int count = 1;
        while (queue.size() > 1) {
            if (count == k) {
                queue.poll();
                count = 1;
            } else {
                Integer poll = queue.poll();
                queue.offer(poll);
                count++;
            }
        }
        return queue.poll();
    }
    
    // 교육과정설계
    public String solution8(String s1, String s2) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char c : s1.toCharArray()) {
            queue.offer(c);
        }

        for (char c : s2.toCharArray()) {
            if (queue.contains(c) && queue.peek() != c) {
                answer = "NO";
            } else if (queue.contains(c) && queue.peek() == c) {
                queue.poll();
            }
        }

        if (queue.size() != 0) {
            answer = "NO";
        }

        return answer;
    }
    
    // 응급실
    public int solution9(int n, int m , int[] array) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;
        for (int i : array) {
            queue.offer(i);
        }

        int i = m;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            boolean max = true;

            for (Integer integer : queue) {
                if (poll < integer) {
                    max = false;
                }
            }

            if (max) {
                answer++;
                if (i == 0) {
                    break;
                }
                i--;
            } else {
                queue.offer(poll);
                if (i == 0) {
                    i = queue.size() - 1;
                } else {
                    i--;
                }
            }


        }
        return answer;
    }
    
    // 응급실 -> 객체 쓰는 방법
    class Person{
        int index;
        int priority;

        public Person(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution10(int n, int m, int[] array) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i : array) {
            queue.offer(new Person(i, array[i]));
        }

        while(!queue.isEmpty()) {
            Person poll = queue.poll();

            for (Person person : queue) {
                if (poll.priority < person.priority) {
                    queue.offer(poll);
                    poll = null;
                    break;
                }
            }

            if (poll != null) {
                answer++;
                if (poll.index == m) {
                    return answer;
                }
            }
        }

        return answer;
    }
}
