import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            System.out.println("No");
            return;
        }

        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int j = 0; j < n; j++) {
            for (int i = sum / 2; i >= arr[j]; i--) {
                if (dp[i - arr[j]])
                    dp[i] = true;
            }
        }
        // for (int i = 0; i <= sum / 2; i++) {
        //     if (dp[i])
        //         System.out.print(1 + " ");
        //     else
        //         System.out.print(0 + " ");
        // }
        // System.out.println();

        if (dp[sum / 2]) System.out.println("Yes");
        else System.out.println("No");
    }
}