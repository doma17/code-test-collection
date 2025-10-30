import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            for (int j = x1; j <= x2; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        boolean isPossible = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                isPossible = true;
                break;
            }
        }

        if (isPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}