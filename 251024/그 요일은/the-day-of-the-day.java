import java.util.*;

public class Main {

    private int[] MONTH_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();

        int a;
        if (A = 'Mon') a = 1;
        else if (A = 'Tue') a = 2;
        else if (A = 'Tue') a = 2;
        
        // 일수 계산
        int days = MONTH_DAYS[m1] - d1;
        for (int i = m1 + 1; i < m2; i++) {
            days += MONTH_DAYS[i];
        }
        days += d2;

        int week = days / 7;
        int leftDay = days % 7;
        System.out.println(week + " " + leftDay);
    }
}