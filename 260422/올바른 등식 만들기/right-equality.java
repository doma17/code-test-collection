import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        
        int[][] dp = new int[N][41];
        dp[0][20 + numbers[0]] = 1;
        dp[0][20 - numbers[0]] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 40; j++) {
                if (0 <= j + numbers[i] && j + numbers[i] <= 40)
                    dp[i][j] += dp[i - 1][j + numbers[i]];
                if (0 <= j - numbers[i] && j - numbers[i] <= 40)
                    dp[i][j] += dp[i - 1][j - numbers[i]];
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j <= 40; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[N - 1][20 + M]);
    }
}