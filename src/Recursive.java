public class Recursive {
    // 재귀함수 자기 자신을 다시 호출하는 것
    // 재귀함수의 종료 조건을 반드시 명시해야 한다.
    // 점화식을 이용하면 복잡한 알고리즘을 간결하게 작성할 수 있다.
    // 모든 재귀함수는 반복문을 이용하여 동일한 기능을 구현할 수 있다.
    // 스택을 사용해야 할 때 구현상 스택 라이브러리 대신에 재귀 함수를 이용하는 경우가 많다.

    // 팩토리얼 구현
    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    // 유클리드 호제법(최대 공약수)(GCD)
    // 최대공약수 : 두개의 자연수중 공통된 약수 중 가장 큰것을 구하는것
    // 유클리드 호제법 A,B에 대하여 (A>B) 일때 A를 B로 나눈 나머지를 R이라고 할때
    // A와 B의 최대 공약수는 B와 R의 최대공약수와 같다.
    public int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return GCD(b, a % b);
    }
}
