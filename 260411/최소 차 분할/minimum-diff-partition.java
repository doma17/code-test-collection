import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int j = 0; j < n; j++) {
            for (int i = sum / 2; i >= arr[j]; i--) {
                if (dp[i - arr[j]])
                    dp[i] = true;
            }
        }
        
        int idx = 0;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[i]) idx = Math.max(idx, i);
        }
        System.out.println(sum - idx * 2);
    }
}