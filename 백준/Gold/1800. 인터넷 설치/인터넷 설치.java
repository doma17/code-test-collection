import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge> {
        int x, cost;

        public Edge(int x, int cost) {
            this.cost = cost;
            this.x = x;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }


    int n, p, k;
    int[] distance;
    ArrayList<Edge>[] edges;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, cost));
            edges[b].add(new Edge(a, cost));
        }

        int left = 0, right = 1000000000, answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dijkstra(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (answer == -1) bw.write("-1\n");
        else bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public boolean dijkstra(int target) {
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (distance[now.x] < now.cost) continue;

            for (Edge next : edges[now.x]) {
                int cost = now.cost + ((next.cost > target) ? 1 : 0) ;
                if (distance[next.x] > cost) {
                    distance[next.x] = cost;
                    pq.add(new Edge(next.x, cost));
                }
            }
        }
        return distance[n] <= k;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
