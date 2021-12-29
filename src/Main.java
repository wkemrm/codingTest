public class Main {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();

        System.out.println("greedy.problem1(1260) = " + greedy.problem1(1260));

        System.out.println("greedy.problem2(25, 3) = " + greedy.problem2(25, 3));

        System.out.println("greedy.problem3(02984) = " + greedy.problem3("02984"));

        System.out.println("greedy.problem4(5, \"2 3 1 2 2\") = " + greedy.problem4(5, "2 3 1 2 2"));

        Implementation implementation = new Implementation();

        System.out.println("implementation.problem1(5, \"R R R U D D\") = " + implementation.problem1(5, "R R R U D D"));
    }
}
