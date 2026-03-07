import java.util.*;
public class Main {

    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        
        // for (int i = 1; i <= n; i++) {
        //     System.out.print(memo[i] + " ");
        // }
        // System.out.println();
        System.out.println(dp(n));
    }

    private static int dp(int num) {
        if (num == 2 || num == 3) return 1;
        if (num < 3) return 0;
        if (memo[num] == -1)
            memo[num] = dp(num - 2) + dp(num - 3);
        return memo[num];
    }
}