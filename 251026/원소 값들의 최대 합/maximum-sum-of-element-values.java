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
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int[] a = arr;

            for (int j = 0; j < m; j++) {
                sum += swap(a, i, a[i]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }

    private static int swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return tmp;
    }
}