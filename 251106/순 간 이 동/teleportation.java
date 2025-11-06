import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int case1 = Math.abs(A - B);
        int case2 = Math.abs(A - x) + Math.abs(B - y);
        int case3 = Math.abs(A - y) + Math.abs(B - x);

        if (case1 <= case2 && case1 <= case3) System.out.println(case1);
        else if (case2 <= case1 && case2 <= case3) System.out.println(case2);
        else if (case3 <= case1 && case3 <= case2) System.out.println(case3);
    }
}