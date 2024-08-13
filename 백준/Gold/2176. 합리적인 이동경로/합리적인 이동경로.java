import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{

        int end, cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    int n, m;
    int s, t;
    int[] distance;
    ArrayList<Edge>[] edges;
    boolean[] visited;
    int answer = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = 1;
        t = 2;

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            edges[i] = new ArrayList<>();

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        dijkstra(t);
        answer = dp();
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public int dp() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)
            pq.add(new Edge(i, distance[i]));
        pq.poll();

        int[] dp = new int[n + 1];
        dp[2] = 1;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge next : edges[now.end]) {
                if (distance[next.end] < distance[now.end])
                    dp[now.end] += dp[next.end];
            }
            if (now.end == 1)
                break;
        }
        return dp[1];
    }

    public void dijkstra(int start) {
        distance[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (Edge next : edges[now.end]) {
                int cost = now.cost + next.cost;

                if (distance[next.end] > cost) {
                    distance[next.end] = cost;
                    pq.add(new Edge(next.end, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
