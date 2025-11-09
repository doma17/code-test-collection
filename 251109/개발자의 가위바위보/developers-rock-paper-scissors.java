import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 1 && b == 3) cnt++;
            else if (a == 2 && b == 1) cnt++;
            else if (a == 3 && b == 2) cnt++;
        }

        System.out.println(cnt);
    }
}