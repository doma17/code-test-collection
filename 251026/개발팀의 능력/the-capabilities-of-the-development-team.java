import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[5];

        int total = 0;
        for (int i = 0; i < 5; i++) {
            dp[i] = sc.nextInt();
            total += dp[i];
        }
        Arrays.sort(dp);

        int minDiff = 2001;
        boolean impossible = true;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int a = dp[i] + dp[j];
                for (int k = i + 1; k < 5; k++) {
                    if (j == k) continue;
                    int b = dp[k];
                    int c = total - (a + b);
                    if (a == b || b == c || c == a) continue;
                    impossible = false;
                    minDiff = Math.min(minDiff, getDiff(a, b, c));
                }
            }
        }
        if (impossible) System.out.println(-1);
        else System.out.println(minDiff);
    }

    public static int getDiff(int a, int b, int c) {
        int minValue = Math.min(a, Math.min(b, c));
        int maxValue = Math.max(a, Math.max(b, c));

        return maxValue - minValue;
    }
}