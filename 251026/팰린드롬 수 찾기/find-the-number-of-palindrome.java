import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.

        int cnt = 0;
        for (int value = x; value <= y; value++) {
            if (isPalin(value)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPalin(int value) {
        boolean is = true;
    
        String v = String.valueOf(value);
        int left = 0;
        int right = v.length() - 1;
        while (left <= right) {
            if (v.charAt(left) != v.charAt(right)) {
                is = false;
                break;
            }
            left++;
            right--;
        }

        return is;
    }
}