import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        int answer = Integer.MAX_VALUE;
        char first = A.charAt(0);
        for (int i = 0; i < A.length(); i++) {
            // 문자열 Shift
            StringBuilder sb = new StringBuilder();
            sb.append(A.substring(A.length() - i, A.length()));
            sb.append(A.substring(0, A.length() - i));

            answer = Math.min(answer, encode(sb.toString()).length());
        }
        System.out.println(answer);
    }

    private static String encode(String input) {
        StringBuilder sb = new StringBuilder();
        char before = input.charAt(0);
        int cnt = 1;
        for (int i = 1; i < input.length(); i++) {
            if (before == input.charAt(i)) {
                cnt++;
            } else {
                sb.append(String.valueOf(before) + cnt);
                before = input.charAt(i);
                cnt = 1;
            }
        }
        sb.append(String.valueOf(before) + cnt);
        
        // System.out.println(input + " " + sb);
        return sb.toString();
    }
}