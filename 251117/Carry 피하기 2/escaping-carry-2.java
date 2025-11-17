import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!isNoCarry(arr[i], arr[j])) continue;
                int sum = arr[i] + arr[j];
                for (int k = j + 1; k < n; k++) {
                    if (!isNoCarry(sum, arr[k])) continue;
                    answer = Math.max(answer, sum + arr[k]);
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isNoCarry(int a, int b) {
        while (a != 0 && b != 0) {
            if ((a % 10) + (b % 10) >= 10) return false;
            a /= 10;
            b /= 10;
        }
        return true;
    }
}