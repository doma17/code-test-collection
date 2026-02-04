import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] A;

    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        arr = new int[m];
        choose(0, 0);

        System.out.println(answer);
    }

    private static void choose(int idx, int start) {
        if (idx == m) {
            int tmp = arr[0];
            for (int i = 1; i < m; i++) {
                tmp = tmp ^ arr[i];
            }
            answer = Math.max(answer, tmp);
            return;
        }

        for (int i = start; i < n; i++) {
            arr[idx] = A[i];
            choose(idx + 1, i + 1);
        }
    }
}