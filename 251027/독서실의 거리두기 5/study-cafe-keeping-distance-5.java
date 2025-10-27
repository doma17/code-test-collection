import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();
        
        List<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seat.charAt(i) == '1') {
                people.add(i);
            }
        }
        int maxMinDistance = 0;

        for (int i = 0; i < n; i++) {
            if (seat.charAt(i) == '1') continue;
            int minDistance = n;
            
            for (int pIndex : people) {
                int distance = Math.abs(i - pIndex);
                minDistance = Math.min(minDistance, distance);
            }
            maxMinDistance = Math.max(maxMinDistance, minDistance);
        }
        System.out.println(maxMinDistance);
    }
}