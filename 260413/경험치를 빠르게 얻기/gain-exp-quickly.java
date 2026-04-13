import java.util.*;

public class Main {

    static int MAX = 100000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] exp = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        
        int[] dp = new int[m + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int e = exp[i];
            int t = time[i];

            if (e >= m) e = m;
            for (int j = m; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, j - e)] + t);
            }
        }

        // for (int i = 0; i <= m; i++) {
        //     if (dp[i] == MAX) System.out.print("- ");
        //     else System.out.print(dp[i] + " ");
        // }
        System.out.println(dp[m]);
    }
}