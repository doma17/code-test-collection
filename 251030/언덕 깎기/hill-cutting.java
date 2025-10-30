import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int minCost = Integer.MAX_VALUE;
        
        int k = 17;
        int MAX_MIN_HEIGHT = 83;
        for (int L = 0; L <= MAX_MIN_HEIGHT; L++) {
            int R = L + k;
            int curCost = 0;
            for (int i = 0; i < n; i++) {
                int cost = 0;

                if (arr[i] < L) {
                    cost = L - arr[i];
                } else if (arr[i] > R) {
                    cost = arr[i] - R;
                }

                curCost += cost * cost;
            }
            minCost = Math.min(minCost, curCost);
        }
        System.out.println(minCost);
    }
}