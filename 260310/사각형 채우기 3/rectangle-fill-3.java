import java.util.*;

public class Main {

    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(dp(n));
    }

    private static long dp(int num) {
        if (num == 0) return 1;
        if (num == 1) return 2;
        if (num == 2) return 7;
        if (memo[num] == -1) {
            memo[num] = (3 * dp(num - 1) + dp(num - 2) - dp(num - 3)) % 1000000007;
            memo[num] = (memo[num] + 1000000007) % 1000000007;
        }
        return memo[num];
    }
}