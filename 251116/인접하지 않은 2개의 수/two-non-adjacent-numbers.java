import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int maxSum = -1;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                maxSum = Math.max(maxSum, arr[i] + arr[j]);
            }
        }
        System.out.println(maxSum);
    }
}