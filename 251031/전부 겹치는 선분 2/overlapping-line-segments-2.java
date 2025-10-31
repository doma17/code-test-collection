import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            for (int x = x1[i]; x <= x2[i]; x++)
                map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        boolean isPass = false;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= n - 1) {
                isPass = true;
            }
        }

        if (isPass) System.out.println("Yes");
        else System.out.println("NO");
    }
}