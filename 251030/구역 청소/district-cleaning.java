import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        Set<Integer> set = new HashSet<>();
        for (int i = a; i <= b; i++) {
            set.add(i);
        }
        for (int i = c; i <= d; i++) {
            set.add(i);
        }
        System.out.println(set.size() - 1);
    }
}