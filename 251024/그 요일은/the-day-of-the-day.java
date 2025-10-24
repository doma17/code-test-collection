import java.util.*;

public class Main {

    private static int[] MONTH_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static int getDayIndex(String day) {
        switch (day) {
            case "Mon": return 1;
            case "Tue": return 2;
            case "Wed": return 3;
            case "Thu": return 4;
            case "Fri": return 5;
            case "Sat": return 6;
            case "Sun": return 7;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        sc.close();

        int aDayIndex = getDayIndex(A);
        int totalDays = 0;

        if (m1 == m2) {
            totalDays = d2 - d1 + 1;
        } else {
            totalDays += MONTH_DAYS[m1] - d1 + 1;
            for (int i = m1 + 1; i < m2; i++) {
                totalDays += MONTH_DAYS[i];
            }
            totalDays += d2;
        }
        
        int count = totalDays / 7; 
        int remainder = totalDays % 7;
        int startDayIndex = 1; 

        for (int i = 0; i < remainder; i++) {
            int currentDayIndex = (startDayIndex + i - 1) % 7 + 1; 
            if (currentDayIndex == aDayIndex) {
                count++;
            }
        }
        System.out.println(count);
    }
}