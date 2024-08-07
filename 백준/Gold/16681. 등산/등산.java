import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{
        int end;
        long cost;

        public Edge(int end, long cost) {
            this.cost = cost;
            this.end = end;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    // 지점개수, 경로개수, 체력소모량, 성취감획득량
    int n, m, d, e;
    long[] height;
    ArrayList<Edge>[] edges;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        height = new long[n + 1];
        for (int i = 1; i <= n; i++)
            height[i] = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, c));
            edges[b].add(new Edge(a, c));
        }

        long[] homeToPeek = dijkstra(1);
        long[] peekToUniv = dijkstra(n);

        long answer = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (homeToPeek[i] == Long.MAX_VALUE) continue;
            if (peekToUniv[i] == Long.MAX_VALUE) continue;
            answer = Math.max(answer, height[i] * e - ((peekToUniv[i] + homeToPeek[i]) * d));
        }

        if (answer == Long.MIN_VALUE)
            bw.write("Impossible\n");
        else
            bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public long[] dijkstra(int start) {
        long[] distance = new long[n + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (distance[now.end] < now.cost) continue;

            for (Edge next : edges[now.end]) {
                if (height[now.end] >= height[next.end]) continue;

                long nextDis = now.cost + next.cost;
                if (distance[next.end] <= nextDis) continue;

                distance[next.end] = nextDis;
                pq.add(new Edge(next.end, nextDis));
            }
        }
        return distance;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
