import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        boolean[] clean = new boolean[101];
        for (int i = a; i <= b; i++) {
            clean[i] = true;
        }
        for (int i = c; i <= d; i++) {
            clean[i] = true;
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (clean[i] && clean[i + 1]) count++;
        }
        System.out.println(count);
    }
}