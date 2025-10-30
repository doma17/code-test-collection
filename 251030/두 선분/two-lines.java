import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        // Please write your code here.

        if (x3 <= x1 && x1 <= x4) {
            System.out.println("intersecting");
        } else if (x3 <= x2 && x2 <= x4) {
            System.out.println("intersecting");
        } else {
            System.out.println("nonintersecting");
        }
    }
}