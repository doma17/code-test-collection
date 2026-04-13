import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int OFFSET = sum;
        int[] dp = new int[2 * sum + 1];
        
        Arrays.fill(dp, -1);
        dp[0 + OFFSET] = 0;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int[] next = new int[2 * sum + 1];
            Arrays.fill(next, -1);

            for (int diff = -sum; diff <= sum; diff++) {
                if (dp[diff + OFFSET] == -1) continue;

                int curA = dp[diff + OFFSET];

                if (diff + x <= sum) {
                    next[diff + x + OFFSET] = Math.max(next[diff + x + OFFSET], curA + x);
                }

                if (diff - x >= -sum) {
                    next[diff - x + OFFSET] = Math.max(next[diff - x + OFFSET], curA);
                }

                next[diff + OFFSET] = Math.max(next[diff + OFFSET], curA);
            }
            dp = next;
        }

        System.out.println(dp[OFFSET]);
    }
}