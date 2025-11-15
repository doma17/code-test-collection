import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        int count = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '(' && input.charAt(i + 1) == '(') {
                for (int j = i + 2; j < input.length() - 1; j++) {
                    if (input.charAt(j) == ')' && input.charAt(j + 1) == ')')
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}