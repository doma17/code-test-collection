import java.util.Scanner;

public class Main {

    static int[] arr;

    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        arr = new int[n];
        choose(0, 1);
    }

    private static void choose(int depth, int value) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) 
                sb.append(arr[i]).append(" ");
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[depth] = i;
            choose(depth + 1, i + 1);
        }
    }
}