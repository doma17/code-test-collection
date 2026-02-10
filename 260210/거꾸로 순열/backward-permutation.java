import java.util.*;
public class Main {

    private static int n;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n + 1];
        choose(0);
    }

    private static void choose(int num) {
        if (num == n) {
            printAnswer();
            return;
        }

        for (int i = n; i > 0; i--) {
            if (visited[i]) continue;
            arr[num] = i;
            visited[i] = true;
            choose(num + 1);
            visited[i] = false;
        } 
    }

    private static void printAnswer() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}