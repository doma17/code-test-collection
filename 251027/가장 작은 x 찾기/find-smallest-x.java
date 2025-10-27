import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int answer = a[0];
        for (int x = 1; x <= b[0] / 2; x++) {
            boolean isPass = true;
            for (int i = 0; i < n; i++) {
                int value = x * (int) Math.pow(2, i + 1);
                if (value < a[i] || b[i] < value) {
                    isPass = false;
                    break; 
                }
            }
            if (isPass) {
                answer = x;
                break;
            }
        }
        System.out.println(answer);
    }
}