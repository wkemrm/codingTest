import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Chapter1 {
    
    // 문자 찾기
    public int solution1(String str, char t) {
        str = str.toLowerCase();
        t = Character.toLowerCase(t);
        int count = 0;
        for (char s : str.toCharArray()) {
            if (s == t) {
                count++;
            }
        }

        return count;
    }
    
    
    // 대소문자 변환
    public String solution2(String str) {
        String answer = "";

        for (char s : str.toCharArray()) {
            // Character.isLowerCase(s) -> 소문자인지 판단
            // Character.isUpperCase(s) -> 대문자인지 판단
            // 이렇게 하는 방식도 있음
            if (s >= 'A' && s <= 'Z') {
                answer += Character.toLowerCase(s);
            } else if (s >= 'a' && s <= 'z') {
                answer += Character.toUpperCase(s);
            }
        }

        return answer;
    }

    // 문장 속 단어
    public String solution3(String str) {
        String[] strings = str.split(" ");
        String answer = "";
        for (String s : strings) {
            if (s.length() > answer.length()) {
                answer = s;
            }
        }

        return answer;
    }

    // 단어 뒤집기 1번쨰 방법
    public ArrayList<String> solution4(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (String s : str) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }
    
    // 단어 뒤집기 2번째 방법
    public ArrayList<String> solution5(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for (String s : str) {
            char[] chars = s.toCharArray();
            int lt = 0;
            int rt = chars.length -1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;

                rt--;
                lt++;
            }
            answer.add(String.valueOf(chars));
        }

        return answer;
    }
    
    // 특정 문자 뒤집기 -> 쉽게 못풀었음 다시 보자
    public String solution6(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;

        while(lt < rt) {
            if (!Character.isAlphabetic(chars[lt])){
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;

                lt++;
                rt--;;
            }

        }

        return String.valueOf(chars);
    }

    // 중복 문자 제거 -> 강의 보고 나서야 풀수 있었음...
    public String solution7(String str) {
        String answer = "";
        for (int i = 0 ; i < str.length() ; i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    // 회문 문자열
    public String solution8(String str) {
        int lt = 0;
        int rt = str.length() - 1;
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        while(lt < rt) {
            if (chars[lt] != chars[rt]) {
                return "NO";
            }
            lt++;
            rt--;
        }
        return "YES";
    }

    // 회문 문자열 2번쨰 방법
    public String solution9(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();

        if (tmp.equalsIgnoreCase(tmp)) answer = "YES";
        
        return answer;
    }
    
    // 팰린드롬
    public String solution10(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length - 1;
        String answer = "YES";

        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else if (chars[lt] != chars[rt]) {
                answer = "NO";
                break;
            } else {
                lt++;
                rt--;
            }
        }

        return answer;
    }
    
    // 팰린드롬 replaceAll 쓰는 방식
    public String solution11(String str) {
        str = str.toLowerCase().replaceAll("[^A-Z]", "");
        String str2 = new StringBuilder(str).reverse().toString();

        String answer = "NO";

        if (str.equals(str2)) {
            answer = "YES";
        }

        return answer;
    }
    
    // 숫자만 추출 -> 정규식을 이용하면 엄청 편하게 구할수 있는듯 정규식 공부 필요
    public String solution12(String str) {
        str = str.replaceAll("[^0-9]", "").replaceAll("^0+","");

        return str;
    }

    // 숫자만 추출 두번째 방법
    public int solution13(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= '0' && x <= '9') answer = answer * 10 + (x - '0');
        }
        return answer;
    }
    
    // 가장 짧은 문자 거리 -> 처음에 어캐 푸는지 감도 안잡혔음 다시 봐야할듯
    public String solution14(String s, String t) {
        char[] chars = s.toCharArray();
        int[] ints = new int[s.length()];
        String answer = "";
        int count = 1000;

        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] == t.charAt(0)) {
                count = 0;
            } else {
                count++;
            }
            ints[i] = count;
        }

        count = 1000;
        for (int i = chars.length - 1 ; i >= 0 ; i--) {
            if (chars[i] == t.charAt(0)) {
                ints[i] = 0;
                count = 0;
            } else {
                count ++;
                ints[i] = Math.min(ints[i], count);
            }
        }
        for (int anInt : ints) {
            answer += " " + anInt;
        }

        answer = answer.trim();


        return answer;
    }
    
    // 문자열 압축 내가 푼 방식
    public String solution15(String str) {
        char[] chars = str.toCharArray();
        char t = chars[0];
        int count = 0;
        String answer = "";

        for (int i = 0 ; i < chars.length ; i++) {
            if (t != chars[i]) {
                answer += t;
                if (count > 1) answer += count;
                t = chars[i];
                count = 1;
            } else {
                count++;
            }
        }

        answer += t;

        if (count > 1) answer += count;

        return answer;
    }

    // 문자열 압축 강의가 푼 방식
    public String solution16(String str) {
        String answer = "";
        str += " ";
        int cnt = 1;

        for (int i = 0 ; i < str.length() - 1 ; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if (cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }

        return answer;
    }
    
    // 암호 내가 푼 방식
    public String solution17(int n, String str) {
        str = str.replace('#', '1').replace('*', '0');
        String answer = "";
        for (int i = 0 ; i < n ; i++) {
            String substring = str.substring(i * 7, i * 7 + 7);
            int integer = Integer.parseInt(substring, 2);
            answer += (char) integer;
        }

        return answer;
    }

}
