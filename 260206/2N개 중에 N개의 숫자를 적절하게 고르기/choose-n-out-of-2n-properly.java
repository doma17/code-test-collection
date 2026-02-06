import java.util.*;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }
        
        choose(0, 0, 0, 0);
        System.out.println(answer);
    }

    static int answer = 10000;

    private static void choose(int idx, int diff, int a, int b) {
        if (n * 2 == idx) {
            if (a == b) {
                answer = Math.min(answer, Math.abs(diff));
            }
            return;
        }

        if (a == n) {
            for (int i = idx; i < n * 2; i++) {
                diff -= arr[i];
            }
            choose(n * 2, diff, n, n);
            return;
        } else if (b == n) {
            for (int i = idx; i < n * 2; i++) {
                diff += arr[i];
            }
            choose(n * 2, diff, n, n);
            return;
        }

        // a 더하기
        choose(idx + 1, diff + arr[idx], a + 1, b);
        // b 빼기
        choose(idx + 1, diff - arr[idx], a, b + 1);
    }
}