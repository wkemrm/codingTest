import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
}
