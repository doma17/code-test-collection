import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[][][] dp = new int[n][m + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j][0] = -100000000;
                dp[i][j][1] = -100000000;
            }
        }
        dp[0][0][0] = 0;
        dp[0][1][1] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;

            for (int j = 1; j <= m; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
                int a = dp[i - 1][j][1] + arr[i];
                int b = dp[i - 1][j - 1][0] + arr[i];
                dp[i][j][1] = Math.max(a, b);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         System.out.print(dp[i][j][0] + " " + dp[i][j][1] + ", ");
        //     }
        //     System.out.println();
        // }

        System.out.println(Math.max(dp[n - 1][m][0], dp[n - 1][m][1]));
    }
}