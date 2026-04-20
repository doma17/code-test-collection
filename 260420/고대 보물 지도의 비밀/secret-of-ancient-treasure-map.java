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
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            int target = arr[i];

            if (target >= 0) {
                for (int j = 0; j <= K; j++) {
                    dp[i][j] = 
                }
            } else {
                for (int j = 0; j <= K; j++) {
                    
                }
            }
        }
    }
}