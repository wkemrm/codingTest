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

    public int[] problem5(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            for (int j = i + 1 ; j < numbers.length ; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            answer[i] = iterator.next();
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }
    public String problem6(int a, int b) {
        int[] day = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int totalDay = 0;
        for (int i = 1 ; i < a ; i++) {
            totalDay += day[i];
        }
        totalDay += b;
        String answer = week[totalDay % 7];
        return answer;
    }

    public int problem7(int[][] sizes) {
        // 가로 세로를 받은 다음에 돌린것과 아닌것을 비교해서 최대치를 유지하면 될듯
        int widthMax = 0;
        int verticalMax = 0;
        for (int i = 0 ; i < sizes.length ; i++) {
            int width = sizes[i][0];
            int vertical = sizes[i][1];

            if (vertical > width) {
                sizes[i][0] = vertical;
                sizes[i][1] = width;
            }
        }

        for (int i = 0 ; i < sizes.length ; i++) {
            if (widthMax <= sizes[i][0]) {
                widthMax = sizes[i][0];
            }
            if (verticalMax <= sizes[i][1]) {
                verticalMax = sizes[i][1];
            }
        }
        int answer = widthMax * verticalMax;
        return answer;
    }

    public int problem8(int n) {

        int i = 1;
        while (true) {
            if (n % i == 1) {
                return i;
            }
            i++;
        }
    }

    public String problem9(String s) {
        int length = s.length();
        String answer = "";
        if (length % 2 == 0) {
           answer += s.charAt((length / 2) - 1);
           answer += s.charAt((length / 2));
        } else {
            answer += s.charAt((length / 2));
        }
        return answer;
    }

    public int[] problem10(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        int preNum = -1;

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == preNum) {
                continue;
            } else {
                answerList.add(arr[i]);
                preNum = arr[i];
            }
        }
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    // 나누어 떨어지는 숫자 배열 레벨 1
    public int[] problem11(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) {
                answerList.add(i);
            }
        }
        if (answerList.size() == 0) {
            answerList.add(-1);
        }

        Collections.sort(answerList);

        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    class Node1 {
        private char index;
        private String string;

        public Node1(char index, String string) {
            this.index = index;
            this.string = string;
        }

        public char getIndex() {
            return index;
        }

        public String getString() {
            return string;
        }
    }
    //문자열 내 마음대로 정렬하기
    public String[] problem12(String[] strings, int n) {
        String[] answer = new String[strings.length];

        Node1[] nodes = new Node1[strings.length];
        for (int i = 0 ; i < strings.length ; i++) {
            nodes[i] = new Node1(strings[i].charAt(n), strings[i]);
        }
        Comparator<Node1> f = new Comparator<Node1>() {
            @Override
            public int compare(Node1 o1, Node1 o2) {
                if (o1.getIndex() == o2.getIndex()) {
                    return o1.getString().compareTo(o2.getString());
                }
                return o1.getIndex() - o2.getIndex();
            }
        };

        Arrays.sort(nodes, f);
        for (int i = 0 ; i < nodes.length ; i++) {
            answer[i] = nodes[i].getString();
        }
        return answer;
    }

    //문자열 내 p와 y의 개수 1레벨
    boolean problem13(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                p++;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                y++;
            }
        }
        if (p == y || (p == 0 && y == 0)) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    //문자열 내림차순으로 배치하기
    public String problem14(String s) {
        String answer = "";
        Character[] chars = new Character[s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            chars[i] = s.charAt(i);
        }
        Comparator<Character> f = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        };
        Arrays.sort(chars, f.reversed());
        for (int i = 0 ; i < chars.length ; i++) {
            answer += chars[i];
        }
        return answer;
    }

    //문자열 다루기 기본
    public boolean problem15(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0 ; i < s.length() ; i++) {
                char a = s.charAt(i);
                if (a < '0' || a > '9') {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }

    //서울에서 김서방 찾기
    public String problem16(String[] seoul) {
        String answer = "김서방은 ";
        for (int i = 0 ; i < seoul.length ; i++) {
            if (seoul[i].equals("Kim")) {
                answer += i;
            }
        }
        answer += "에 있다";
        return answer;
    }

    //소수 찾기 *********************************************
    public int problem17(int n) {
        int answer = 0;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 0;
        for (int i = 2 ; i <= n ; i++) {
            array[i] = i;
        }

        for (int i = 2 ; i <= n ; i++) {
            if (array[i] == 0) continue;

            for (int j = i + i ; j <=n ; j+=i) {
                array[j] = 0;
            }
        }

        for (int i = 2 ; i <= n ; i++) {
            if (array[i] != 0) {
                answer ++;
            }
        }

        return answer;
    }

    public String problem18(String s, int n) {
        String answer = "";
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] <= 'Z' && chars[i] >= 'A') {
                if ((chars[i] + n) > 'Z') {
                    answer += Character.toString((chars[i] + n) % 'Z' + 'A' - 1);
                } else {
                    answer += Character.toString(chars[i] + n);
                }
            } else if (chars[i] <= 'z' && chars[i] >= 'a') {
                if ((chars[i] + n) > 'z') {
                    answer += Character.toString((chars[i] + n) % 'z' + 'a' - 1);
                } else {
                    answer += Character.toString(chars[i] + n);
                }
            } else if (chars[i] == ' ') {
                answer += Character.toString(chars[i]);
            }
        }
        return answer;
    }
    
    //이상한 문자 만들기 ************ 다시 풀어야함
    public String problem19(String s) {
        String answer = "";
        String[] s1 = s.split(" ");
        for (int i = 0 ; i < s1.length ; i++) {
            char[] chars = s1[i].trim().toCharArray();
            for (int j = 0 ; j < chars.length ; j++) {
                if (j % 2 == 0) {
                    answer += Character.toUpperCase(chars[j]);
                } else {
                    answer += Character.toLowerCase(chars[j]);
                }
            }
            answer += " ";
        }
        return answer.trim();
    }

    //자릿수 더하기
    public int problem20(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        for (int i = 0 ; i < s.length() ; i++) {
            answer += s.charAt(i) - '0';
        }

        return answer;
    }

    //자연수 뒤집어 배열로 만들기
    public int[] problem21(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        int j = 0;
        for (int i = s.length() - 1 ; i >= 0 ; i--) {
            answer[j] = s.charAt(i) - '0';
            j++;
        }
        return answer;
    }

    //정수 내림차순으로 배치하기
    public long problem22(long n) {
        String s = "" + n;
        Integer[] intArray = new Integer[s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            intArray[i] = s.charAt(i) - '0';
        }
        Arrays.sort(intArray, Comparator.reverseOrder());
        String sAnswer = "";
        for (int i = 0 ; i < intArray.length ; i++) {
            sAnswer += intArray[i];
        }

        long answer = Long.parseLong(sAnswer);
        return answer;
    }

    //정수 제곱근 판별
    public long problem23(long n) {
        long sqrt = (long)Math.sqrt(n);
        if (n == (long)Math.pow(sqrt, 2)) {
            return (long)Math.pow(sqrt + 1, 2);
        } else {
            return -1;
        }
    }

    //제일 작은 수 제거하기
    public int[] problem24(int[] arr) {
        int[] answer = new int[arr.length - 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < arr.length ; i++) {
            list.add(arr[i]);
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = 0 ; i < list.size() ; i++) {
            if (list.get(i) == arr[0]) {

            } else {
                answer[j] = list.get(i);
                j++;
            }
        }
        if (answer.length == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    //콜라츠 추측
   public long problem24(long num) {
       long answer = 0;

        while (true) {
            if (answer >= 500) {
                return -1;
            }
            if (num == 1) {
                break;
            }
            if (num % 2 == 0) {
                num = num/2;
            } else {
                num = (num * 3) + 1;
            }
            answer++;
        }
        return answer;
    }

    public boolean problem25(int x) {
        int firstNum = x;
        int total = 0;
        while (true) {
            total += (x % 10);
            System.out.println(total);
            if (x < 10) {
                break;
            }
            x /= 10;
        }
        if (firstNum % total == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String problem26(String phone_number) {
        String answer = "";
        String lastNum = phone_number.substring(phone_number.length() - 4);
        String preNum = phone_number.substring(0, phone_number.length() - 4);
        for (int i = 0 ; i < preNum.length() ; i++) {
            answer += "*";
        }
        answer += lastNum;
        return answer;
    }

    public int[][] problem27(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0 ; i < arr1.length ; i++) {
            for (int j = 0 ; j < arr1[i].length ; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public long[] problem28(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0 ; i < n ; i++) {
            answer[i] = x * (i + 1);
        }
        return answer;
    }

    //[1차] 다트 게임
    public int problem29(String dartResult) {
        Map<Character, Integer> bonus = new HashMap<>(){{
            put('S', 1);
            put('D', 2);
            put('T', 3);
        }};

        Map<Character, Integer> option = new HashMap<>() {{
            put('*', 2);
            put('#', -1);
        }};

        int point = 0;
        List<Integer> total = new ArrayList<>();
        for (int i = 0 ; i < dartResult.length() ; i++) {
            char c = dartResult.charAt(i);
            if ('1' == c && dartResult.charAt(i + 1) == '0'){
                total.add(point, 10);
                i++;
                point++;
            } else if ('0' <= c && '9' >= c) {
                total.add(point, c - '0');
                point++;
            } else if (bonus.containsKey(c)) {
                total.set(point - 1, (int)Math.pow(total.get(point - 1), bonus.get(c)));
            } else if (option.containsKey(c)) {
                if (c == '*') {
                    if (point - 2 >= 0) {
                        total.set(point - 2, total.get(point - 2) * 2);
                        total.set(point - 1, total.get(point - 1) * 2);
                    } else {
                        total.set(point - 1, total.get(point - 1) * 2);
                    }
                } else if (c == '#') {
                    total.set(point - 1, total.get(point - 1) * -1);
                }
            }
        }
        int answer = 0;
        for (Integer integer : total) {
            answer += integer;
        }
        return answer;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0 ; i < n ; i++) {
            int a = arr1[i] | arr2[i];
            String s = Integer.toBinaryString(a);
            int length = s.length();
            if (length < n) {
                for (int j = 0 ; j < (n - length) ;j++) {
                    s = "0" + s;
                }
            }
            System.out.println(s);
            answer[i] = s.replace("0", " ").replace("1", "#");

        }
        return answer;
    }
}
