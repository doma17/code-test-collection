import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 < t) continue;
                int cnt = 0;
                int cost = 0;
                for (int k = i; k <= j; k++) {
                    cost += Math.abs(h - arr[k]);
                    cnt++;
                }
                minCost = Math.min(minCost, cost);
            }
        }
        System.out.println(minCost);
    }
}