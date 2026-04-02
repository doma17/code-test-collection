import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] num = new int[] {1, 2, 5};
        int[] dp = new int[n + 1];
        for (int i = 0; i < 3; i++) {
            if (num[i] <= n) dp[num[i]] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < num[j]) break;
                dp[i] += dp[i - num[j]];
            }
        }

        System.out.println(dp[n]);
    }
}