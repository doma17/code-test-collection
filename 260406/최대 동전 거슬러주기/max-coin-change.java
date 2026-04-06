import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int[] dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] <= m) dp[arr[i]] = 1;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < arr[j]) break;
                dp[i] = Math.max(dp[i], dp[i - arr[j]] + 1);
            }
        }
        // for (int i = 0; i <= m; i++) System.out.print(i + " ");
        // System.out.println();
        // for (int i = 0; i <= m; i++) System.out.print(dp[i] + " ");
        // System.out.println();

        int result = dp[m];
        if (dp[m] == 0) result = -1;
        System.out.println(dp[m]);
    }
}