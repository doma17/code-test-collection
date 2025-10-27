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
        
        int minCost = 100000;
        for(int a = 1; a <= 9; a++) {
            int cost = 0;
            for(int i = 0; i < n; i++) {
                if(a <= arr[i] && arr[i] <= a + k)
                    continue;
                else if(arr[i] < a)
                    cost += a - arr[i];
                else
                    cost += arr[i] - (a + k);
            }
            
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }
}
