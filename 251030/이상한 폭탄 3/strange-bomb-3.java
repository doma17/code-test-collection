import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++)
            bombs[i] = sc.nextInt();

        boolean[] visited = new boolean[n];
        int maxCnt = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int b = bombs[i];
            int cnt = 1;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while (!q.isEmpty()) {
                int idx = q.poll();
                for (int j = idx + 1; j <= idx + k && j < n; j++) {
                    if (visited[idx]) continue;
                    if (b == bombs[j]) {
                        cnt++;
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }

            if (maxCnt == cnt) {
                if (answer < b) {
                    answer = b;
                }
            } else if (maxCnt < cnt) {
                answer = b;
                maxCnt = cnt;
            }
        }
        if (maxCnt == 1) System.out.println(0);
        else System.out.println(answer);
    }
}