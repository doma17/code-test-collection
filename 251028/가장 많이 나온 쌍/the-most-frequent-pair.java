import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String tmp;
            if (a > b) tmp = b + " " + a;
            else tmp = a + " " + b;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        int maxCount = 0;
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            maxCount = Math.max(maxCount, x.getValue());
        }
        System.out.println(maxCount);
    }
}