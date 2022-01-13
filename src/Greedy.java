import java.util.*;

public class Greedy {
    // 그리디는 매상황 최선을 고르는 것이다.
    // 최소한의 아이디어를 떠올리고 이것이 정당한지 검토할 수 있어야 한다.
    // 대표적인 문제 : 거스름 돈 문제
    // 500, 100, 50원으로 거슬러 준다.

    // 거스름돈 문제
    public int problem1(int n){
        int count = 0;

        int array[] = {500, 100, 50, 10};

        for (int coin : array) {
            count += n / coin;
            n %= coin;
        }

        return count;
    }

    // 1이 될때까지
    public int problem2(int n, int k) {
        int count = 0;

        while (true) {
            if (n == 1) {
                return count;
            }
            if (n % k == 0) {
                n /= k;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }
    }

    // 곱하기 혹은 더하기
    public int problem3(String s) {
        int result = 0;
        // 1이나 0만 아니면 곱하는게 무조건 이득
        result += s.charAt(0) - '0';

        for (int i = 1 ; i < s.length() ; i++) {
            int number = s.charAt(i) - '0';

            if (result <= 1 || number <= 1) {
                result += number;
            } else {
                result *= number;
            }
        }

        return result;
    }

    // 모험가 길드
    public int problem4(int n, String k) {
        int result = 0;
        String[] array = k.split(" ");
        List<Integer> intArray = new ArrayList<>();
        for (int i = 0 ; i < array.length ; i++) {
            intArray.add(Integer.valueOf(array[i]));
        }
        Collections.sort(intArray);

        int count = 0;
        for (int i = 0 ; i < intArray.size() ; i++) {
            int fear = intArray.get(i);
            count++;

            if (count >= fear) {
                result++;
                count = 0;
            }
        }
        return result;
    }

    //만들 수 없는 금액 p314
    public int problem5() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> su = new ArrayList<>();
        for (int i = 0 ; i < n ; i ++) {
            su.add(sc.nextInt());
        }

        int target = 1;
        for (int i = 0 ; i < su.size(); i++) {
            if (target < su.get(i)) break;
            target += su.get(i);
        }
        return target;
    }

    // 볼링공 고르기 p315
    public int problem6() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> su = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            su.add(sc.nextInt());
        }
        int count = 0;
        for (int i = 0 ; i < su.size() - 1 ; i++) {
            for (int j = i + 1 ; j < su.size() ; j++) {
                if (su.get(i) != su.get(j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public class Item{
        int time;
        int idx;

        public Item(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
    Comparator<Item> CompTime = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.time - o2.time;
        }
    };
    Comparator<Item> CompIdx = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.idx - o2.idx;
        }
    };
    // 무지의 먹방 라이브 p316
    public int problem7(int[] food_times, long k) {
        List<Item> list = new ArrayList<>();
        for (int i = 0 ; i < food_times.length ; i++) {
            list.add(new Item(food_times[i], i + 1));
        }
        list.sort(CompTime);

        int pretime = 0;
        int n = food_times.length;
        int i = 0;

        for (Item item : list) {
            int diff = item.time - pretime;

            if (diff != 0 ) {
                long spend = diff * n;
                if (spend <= k) {
                    k -= spend;
                    pretime = item.time;
                } else {
                    k %= n;
                    list.subList(i, food_times.length).sort(CompIdx);
                    return list.get(i + (int)k).idx;
                }
            }
            ++i;
            --n;
        }

        return -1;
    }
}
