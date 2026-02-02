import java.util.*;

public class Main {

    static int answer = Integer.MAX_VALUE;
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        jump(0, 0);

        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    private static void jump(int idx, int count) {
        if (idx == n - 1) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = arr[idx]; i > 0; i--) {
            if (idx + i < n)
                jump(idx + i, count + 1);
        }
    }
}