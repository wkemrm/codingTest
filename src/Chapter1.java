import java.util.ArrayList;
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

}
