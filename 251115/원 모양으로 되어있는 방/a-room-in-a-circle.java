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
        
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int distance = 0;
            int count = 1;
            for (int j = i + 1; j <= n; j++) {
                if (j == n) j = 0;
                if (j == i) break;
                distance += count++ * arr[j];
            }
            minDistance = Math.min(minDistance, distance);
        }
        System.out.println(minDistance);
    }
}