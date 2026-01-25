import java.util.Scanner;
public class Main {

    static int[] arr;
    static int answer = 0;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        arr = new int[n];
        choose(0, 1);

        System.out.println(answer);
    }

    private static void choose(int depth, int value) {
        if (depth == n) {
            if (isBeautiful()) answer++;
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            choose(depth + 1, i + 1);
        }
    }

    private static boolean isBeautiful() {
        int v = arr[0];
        int count = 1;
        int idx = 0;
        while (idx++ < arr.length - 1) {
            if (arr[idx - 1] == arr[idx]) {
                count++;
            } else {
                if (count % v != 0) return false;
                v = arr[idx];
                count = 1;
            }
        }
        if (count % v != 0) return false;
        return true;
    }
}