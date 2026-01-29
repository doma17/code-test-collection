import java.util.Scanner;
public class Main {

    static int k, n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];

        choose(0);
    }

    private static void choose(int num) {
        if (num == n) {
            for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (num >= 2) {
                if (arr[num - 2] == i && arr[num - 1] == i) continue;
                arr[num] = i;
                choose(num + 1);
                continue;
            }
            arr[num] = i;
            choose(num + 1);
        }
    }
}