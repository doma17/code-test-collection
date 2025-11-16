import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != 'C') continue;
            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j) != 'O') continue;
                for (int k = j + 1; k < n; k++) {
                    if (str.charAt(k) == 'W') count++;
                }
            }
        }
        System.out.println(count);
    }
}