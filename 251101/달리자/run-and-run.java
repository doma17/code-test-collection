import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        
        int cost = 0;
        for (int i = n - 1; i > 0; i--) {
            int diff = a[i] - b[i];
            cost += Math.abs(diff);
            a[i - 1] += diff;
        }
        System.out.println(cost);
    }
}