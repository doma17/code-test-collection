import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] distance;
    static int[] cost;

    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());

        distance = new int[n + 1];
        cost = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split(" ");
            cost[i] = Integer.parseInt(tmp[0]);

            for (int j = 1; j < tmp.length; j++) {
                int now = Integer.parseInt(tmp[j]);
                if (now == -1) {
                    break;
                }
                list[now].add(i);
                distance[i]++;
            }
        }

        // Process
        topology();
    }

    public static void topology() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (distance[i] == 0) {
                q.add(i);
            }
        }

        int[] result = new int[n + 1];
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                distance[next]--;

                result[next] = Math.max(result[next], result[now] + cost[now]);
                if (distance[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // Output
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + cost[i]);
        }
    }
}