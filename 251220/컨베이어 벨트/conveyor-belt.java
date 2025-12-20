import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        
        int[] belt = new int[2 * n];
        for (int i = 0; i < n; i++) belt[i] = sc.nextInt();
        for (int i = n; i < 2 * n; i++) belt[i] = sc.nextInt();
        
        int shift = t % (2 * n);
        int[] result = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
        
            int newPos = (i + shift) % (2 * n);
            result[newPos] = belt[i];
        }

        for (int i = 0; i < n; i++) System.out.print(result[i] + " ");
        System.out.println();
        for (int i = n; i < 2 * n; i++) System.out.print(result[i] + " ");
    }
}