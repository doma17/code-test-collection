import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int cnt = 1;

        char[] arr = seats.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            char x = arr[i];
            if (x == '1') {
                maxLength = Math.max(maxLength, cnt);
                minLength = Math.min(minLength, cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        if (minLength <= maxLength / 2) {
            System.out.println(minLength);
        } else {
            System.out.println(maxLength / 2);
        }
    }
}