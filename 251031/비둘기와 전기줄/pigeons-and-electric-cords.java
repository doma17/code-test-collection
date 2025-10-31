import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int pigeon = sc.nextInt();
            int moveDir = sc.nextInt();

            int curDir = map.getOrDefault(pigeon, -1);
            if (curDir != -1) {
                if (curDir != moveDir) {
                    map.put(pigeon, curDir * -1);
                    count++;
                }
            } else {
                map.put(pigeon, moveDir);
            }
        }
        System.out.println(count);
    }
}