import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int maxSum = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int curIndex = i;

            for (int j = 0; j < m; j++) {
                int value = arr[curIndex];
                sum += value;

                int nextIndex = value;
                if (nextIndex < 1 || nextIndex > n) break;

                curIndex = nextIndex;
            }

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}