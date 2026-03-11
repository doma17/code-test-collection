import java.util.*;
public class Main {

    static int n;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(dp(n));
    }

    private static int dp(int num) {
        if (num == 0) memo[0] = 1;
        if (num == 1) memo[1] = 1;
        if (num == 2) memo[2] = 2;
        if (num == 3) memo[3] = 5;
        if (memo[num] == -1) {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += dp(i - 1) * dp(num - i);
            }
            memo[num] = sum;
        }
        return memo[num];
    }
}