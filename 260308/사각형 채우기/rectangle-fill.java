import java.util.*;
public class Main {

    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(dp(n));
    }

    private static int dp(int num) {
        if (num == 1) memo[1] = 1;
        if (num == 2) memo[2] = 2;
        if (num == 3) memo[3] = 3;
        if (memo[num] == -1)
            memo[num] = (dp(num - 1) + dp(num - 2)) % 10007;
        return memo[num];
    }
}