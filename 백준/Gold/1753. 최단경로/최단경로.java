import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int v, e, k;
    static ArrayList<Edge>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        v = Integer.parseInt(tmp[0]);
        e = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 1; i <= e; i++) {
            tmp = br.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int weight = Integer.parseInt(tmp[2]);

            list[from].add(new Edge(to, weight));
        }

        dijkstra(k);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (distance[cur.index] < cur.weight) {
                continue;
            }

            for (Edge next : list[cur.index]) {
                int nextDist = distance[cur.index] + next.weight;
                
                if (nextDist < distance[next.index]) {
                    distance[next.index] = nextDist;
                    pq.add(new Edge(next.index, nextDist));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    static class Edge {
        int index;
        int weight;

        public Edge(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}