import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.

        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int cnt = 0;
        for (int i = a; i < b; i++) {
            if (isPerfect(i)) continue;
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPerfect(int n) {
        if (n % 2 == 0) return true;
        if ((n % 10 == 5)) return true;
        if (n % 3 == 0 && n % 9 != 0) return true;
        return false;
    }
}