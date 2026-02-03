import java.util.*;

public class Main {

    static int n, m;

    static int[] arr;
    static boolean[] used;

    // 1이상 N 이하의 숫자 중 M
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        arr = new int[m];
        choose(0, 1);
    }

    static void choose(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < m; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[idx] = i;
            choose(idx + 1, i + 1);
        }
    }
}