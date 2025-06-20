import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;
    static ArrayList<Edge>[] list;
    static PriorityQueue<Integer>[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(tmp[2]);

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        distance = new PriorityQueue[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = new PriorityQueue<>(k, (x, y) -> x < y ? 1 : -1);
        }

        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);

            list[a].add(new Edge(b, cost));
        }

        dijkstra(1);

        
        // Output
        for (int i = 1; i <= n; i++) {
            if (distance[i].size() == k) {
                bw.write(distance[i].peek() + "\n");    
            } else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start].add(0);

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            for (var next : list[cur.index]) {
                // 현재 노드 비용 + 경로 비용
                int totalCost = cur.cost + next.cost;

                if (distance[next.index].size() < k) {
                    distance[next.index].add(totalCost);
                    pq.add(new Edge(next.index, totalCost));
                } else if (distance[next.index].peek() > totalCost) {
                    distance[next.index].poll();
                    distance[next.index].add(totalCost);
                    pq.add(new Edge(next.index, totalCost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int index;
        int cost;

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost < e.cost ? -1 : 1;
        }
    }
}