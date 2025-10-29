import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count = j - i + 1;
                int minValue = arr[i];
                int maxValue = arr[j];
                if (maxValue - minValue <= k) {
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        System.out.println(maxCount);
    }
}
