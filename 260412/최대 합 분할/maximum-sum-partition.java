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
            int[] nextDp = new int[2 * sum + 1];
            Arrays.fill(nextDp, -1);

            for (int diff = -sum; diff <= sum; diff++) {
                if (dp[diff + OFFSET] == -1) continue;

                int currentA = dp[diff + OFFSET];

                if (diff + x <= sum) {
                    nextDp[diff + x + OFFSET] = Math.max(nextDp[diff + x + OFFSET], currentA + x);
                }

                if (diff - x >= -sum) {
                    nextDp[diff - x + OFFSET] = Math.max(nextDp[diff - x + OFFSET], currentA);
                }

                nextDp[diff + OFFSET] = Math.max(nextDp[diff + OFFSET], currentA);
            }
            dp = nextDp;
        }

        System.out.println(dp[OFFSET]);
    }
}