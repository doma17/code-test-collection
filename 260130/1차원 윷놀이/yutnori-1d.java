import java.util.Scanner;
public class Main {

    static int n, m, k;
    static int[] nums;

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        arr = new int[k];
        choose(0);

        System.out.println(answer);
    }

    static int answer = 0;

    private static void choose(int turn) {
        if (turn == n) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i] >= m - 1) count++;
                // System.out.print(arr[i] + " ");
            }
            // System.out.println("\n" + answer + " : " + count);
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < k; i++) {
            arr[i] += nums[turn];
            choose(turn + 1);
            arr[i] -= nums[turn];
        }
    }
}