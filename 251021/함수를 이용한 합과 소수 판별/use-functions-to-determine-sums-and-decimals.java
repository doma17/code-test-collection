import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i) && isAllEven(i)) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static boolean isAllEven(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum % 2 == 0) {
            return true;
        }
        return false;
    }
}