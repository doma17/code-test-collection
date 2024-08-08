import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{
        int x, y, hp;

        public Edge(int x, int y, int hp) {
            this.x = x;
            this.y = y;
            this.hp = hp;
        }

        @Override
        public int compareTo(Edge o) {
            return this.hp - o.hp;
        }
    }

    final int MAX_INDEX = 501;
    final int DEATH = 10000000;
    int n, m;
    int[][] matrix = new int[MAX_INDEX][MAX_INDEX];
    int[][] health = new int[MAX_INDEX][MAX_INDEX];

    int[] dx = new int[] {1, 0, 0, -1};
    int[] dy = new int[] {0, 1, -1, 0};

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int[] m : matrix)
            Arrays.fill(m, 0);

        // 위험 구역
        n = Integer.parseInt(br.readLine());
        getAreaInfo(n, br, 1);

        // 죽음 구역
        m = Integer.parseInt(br.readLine());
        getAreaInfo(m, br, DEATH);

        dijkstra(0, 0);

        if (health[500][500] >= DEATH)
            bw.write("-1\n");
        else
            bw.write(health[500][500] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public void dijkstra(int startX, int startY) {
        for (int i = 0; i < MAX_INDEX; i++)
            for (int j = 0; j < MAX_INDEX; j++)
                health[i][j] = DEATH;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startX, startY, 0));
        health[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;

                if (nextX < 0 || nextX >= MAX_INDEX || nextY < 0 || nextY >= MAX_INDEX) continue;
                if (matrix[nextX][nextY] == DEATH) continue;

                int nextHp = matrix[nextX][nextY] + now.hp;

                if (nextHp < health[nextX][nextY]) {
                    health[nextX][nextY] = nextHp;
                    pq.add(new Edge(nextX, nextY, nextHp));
                }
            }
        }
    }

    private void getAreaInfo(int n, BufferedReader br, int DEATH) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
            }
            if (y1 > y2) {
                int tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    matrix[j][k] = DEATH;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
