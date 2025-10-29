import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seat = sc.next();

        char[] arr = seat.toCharArray();

        ArrayList<Integer> defaultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') defaultList.add(i);
        }

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') continue;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == '1') continue;
                ArrayList<Integer> seatList = new ArrayList<>(defaultList);
                seatList.add(i);
                seatList.add(j);

                Collections.sort(seatList);
                int minDistance = 101;
                for (int k = 0; k < seatList.size() - 1; k++) {
                    int distance = seatList.get(k + 1) - seatList.get(k);
                    minDistance = Math.min(minDistance, distance);
                }
                maxDistance = Math.max(maxDistance, minDistance);
            }
        }
        System.out.println(maxDistance);
    }
}