import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        if (m > 12) {
            System.out.println("No");
        } else if ((m == 4 || m == 6 || m == 9 || m == 12) && d > 30) {
            System.out.println("No");
        } else if (d > 31) {
            System.out.println("No");
        } else if (m == 2 && d > 28) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}