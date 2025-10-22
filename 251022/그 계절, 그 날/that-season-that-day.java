import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        if (isPossible(y, m, d)) {
            if (3 <= m && m <= 5) System.out.println("Spring");
            else if (6 <= m && m <= 8) System.out.println("Summer");
            else if (9 <= m && m <= 11) System.out.println("Fall");
            else if (11 <= m || m <= 2) System.out.println("Winter");
        } else {
            System.out.println("-1");
        }
    }

    public static boolean isPossible(int y, int m, int d) {
        boolean isYunYear = false;
        if (y % 4 == 0) {
            if (y % 100 != 0) {
                isYunYear = true;
            } else {
                if (y % 400 == 0) 
                    isYunYear = true;
            }
        }

        if (m == 2) {
            if (isYunYear) {
                if (d < 30) return true;
            } else {
                if (d < 29) return true;
            }
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d < 31) return true;
        } else {
            if (d < 32) return true;
        }
        return false;
    }
}