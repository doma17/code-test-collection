import java.util.*;
public class Main {

    static int MIN = -1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[][] dp = new int[N][K + 1];
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], MIN);
        if (arr[0] >= 0)
            dp[0][0] = arr[0];
        else 
            dp[0][1] = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] >= 0) {
                for (int j = 0; j <= K; j++) {
                    if (dp[i - 1][j] != MIN) {
                        dp[i][j] = dp[i - 1][j] + arr[i];
                    }
                    if (j == 0) {
                        dp[i][j] = Math.max(dp[i][j], arr[i]);
                    }
                }
            } else {
                for (int j = 0; j < K; j++) {
                    if (dp[i - 1][j] != MIN) {
                        dp[i][j + 1] = dp[i - 1][j] + arr[i];
                    }
                }
                if (K >= 1) {
                    dp[i][1] = Math.max(dp[i][1], arr[i]);
                }
            }
        }

        int answer = MIN;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= K; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        System.out.println(answer);
    }
}