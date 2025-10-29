import java.util.*;
public class Main {

    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = Math.max(arr[0], arr[n - 1]); i <= 100; i++) {
            if (isPossible(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean isPossible(int limit) {
        int last = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= limit) {
                if (i - last > k) {
                    return false;
                }
                last = i;
            }
        }
        return true;
    }
}