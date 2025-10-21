import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.

        for (int i = 0; i + n2 - 1 < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a[i + j] != b[j]) break;
                if (j == n2 - 1) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}