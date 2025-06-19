import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<Edge>[] list;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        distance = new long[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        String[] tmp;
        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int weight = Integer.parseInt(tmp[2]);

            list[from].add(new Edge(to, weight));
        }

        tmp = br.readLine().split(" ");
        int start = Integer.parseInt(tmp[0]);
        int end = Integer.parseInt(tmp[1]);

        dijkstra(start, end);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> (int) (a.weight - b.weight));
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (distance[cur.index] < cur.weight) {
                continue;
            }

            for (Edge next : list[cur.index]) {
                long nextDist = distance[cur.index] + next.weight;
                
                if (nextDist < distance[next.index]) {
                    distance[next.index] = nextDist;
                    pq.add(new Edge(next.index, nextDist));
                }
            }
        }

        System.out.println(distance[end]);
    }

    static class Edge {
        int index;
        long weight;

        public Edge(int index, long weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}