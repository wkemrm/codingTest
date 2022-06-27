import java.util.*;

public class Chapter4 {
    // 학급회장 문제 map.getOrDefault만 알아가면 될꺼같다..
    public char solution1(int n, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 이것도..
        // map.containsKey('A') A가 있는지-> true, false 반환
        // map.size() => key의 종류 개수 반환
        // map.remove('A') => 특정 key를 삭제

        char answer = ' ';
        int max = Integer.MIN_VALUE;

        for (Character key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
    
    // 아나그램
    public String solution2(String a, String b) {
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for (char c : a.toCharArray()) {
            aMap.put(c, aMap.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
        }

        boolean answer = true;

        for (Character key : aMap.keySet()) {
            if (!bMap.containsKey(key) || aMap.get(key) != bMap.get(key)) {
                answer = false;
                break;
            }
        }

        if (answer) {
            return "YES";
        } else {
            return "NO";
        }
    }

    // 매출액의 종류 => 틀렸었음
    public List<Integer> solution3(int n, int m, int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int lt = 0;
        for (int i = 0 ; i < m - 1 ; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        for (int rt = m - 1 ; rt < n ; rt++) {
            map.put(array[rt], map.getOrDefault(array[rt], 0) + 1);
            answer.add(map.size());
            map.put(array[lt], map.get(array[lt]) - 1);
            if (map.get(array[lt]) == 0) {
                map.remove(array[lt]);
            }
            lt++;
        }

        return answer;
    }
    
    // 모든 아나그램 찾기
    public int solution4(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, 0);
        }
    }
}
