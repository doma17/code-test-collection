import java.util.*;
public class Main {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n));
    }

    private static int fibo(int x) {
        if (dp[x] != -1) return dp[x];
        if (x <= 2) dp[x] = 1;
        else dp[x] = fibo(x - 1) + fibo(x - 2);
        return dp[x];
    }
}