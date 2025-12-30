import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n * 3];
        for (int i = 0; i < n * 3; i++) {
            arr[i] = sc.nextInt();
        }

        while (t-- > 0) {
            int temp = arr[n * 3 - 1];
            for (int i = n * 3 - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n * 3; i++) {
            sb.append(arr[i] + " ");
            if ((i + 1) % n == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}