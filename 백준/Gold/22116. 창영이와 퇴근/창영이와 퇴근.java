import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{
        int x, y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    int n;
    int[][] height;
    int[] dx = new int[] {1, 0, 0, -1};
    int[] dy = new int[] {0, 1, -1, 0};

    int[][] slope;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        height = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dijkstra(1, 1);

        bw.write(slope[n][n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void dijkstra(int startX, int startY) {
        slope = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                slope[i][j] = Integer.MAX_VALUE;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startX, startY, 0));
        slope[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + e.x;
                int nextY = dy[i] + e.y;

                if (nextX < 1 || nextX > n || nextY < 1 || nextY > n)
                    continue;

                int absCost = Math.abs(height[e.x][e.y] - height[nextX][nextY]);
                int nextCost = Math.max(e.cost, absCost);

                if (nextCost < slope[nextX][nextY]) {
                    slope[nextX][nextY] = nextCost;
                    pq.add(new Edge(nextX, nextY, nextCost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
