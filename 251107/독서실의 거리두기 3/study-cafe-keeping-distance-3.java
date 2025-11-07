import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        
        int maxLength = 0;
        int cnt = 0;
        for (char x : seats.toCharArray()) {
            if (x == '1') {
                maxLength = Math.max(maxLength, cnt);
                cnt = 0;
            }
            cnt++;
        }
        System.out.println(maxLength / 2);
    }
}