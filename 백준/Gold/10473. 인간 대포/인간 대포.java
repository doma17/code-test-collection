import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{
        int next;
        float cost;

        public Edge(int next, float cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Float.compare(this.cost, o.cost);
        }
    }

    int n;
    float startX, startY, endX, endY;

    ArrayList<Edge>[] edges;
    float[] time; // distance
    float[][] place; // 위치정보 저장
    boolean[] visited; // 이미 방문했는지 확인

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Float.parseFloat(st.nextToken());
        startY = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        endX = Float.parseFloat(st.nextToken());
        endY = Float.parseFloat(st.nextToken());
        n = Integer.parseInt(br.readLine());

        edges = new ArrayList[n + 2];
        for (int i = 0; i <= n + 1; i++)
            edges[i] = new ArrayList<>();
        time = new float[n + 2];
        Arrays.fill(time, Float.MAX_VALUE);
        place = new float[n + 2][n + 2];
        visited = new boolean[n + 2];

        place[0][0] = startX;
        place[0][1] = startY;
        place[n + 1][0] = endX;
        place[n + 1][1] = endY;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            place[i][0] = Float.parseFloat(st.nextToken());
            place[i][1] = Float.parseFloat(st.nextToken());
        }

        // 시작 지점 -> 대포, 목적지 | 걸어가서 걸리는 시간
        for (int i = 1; i <= n + 1 ; i++) {
            float dis = (float) Math.sqrt(Math.pow(place[0][0] - place[i][0], 2) + Math.pow(place[0][1] - place[i][1], 2));
            float byWalking = (float) (dis / 5.0);
            edges[0].add(new Edge(i, byWalking));
        }

        // 각 대포 -> 각 대포, 목적지 | 걷는 시간 or 날라가는 시간 비교해서 작은 시간 대입
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                float dis = (float) Math.sqrt(Math.pow(place[i][0] - place[j][0], 2) + Math.pow(place[i][1] - place[j][1], 2));
                float byWalking = (float) (dis / 5.0);
                float byCannon = (float) (Math.abs(dis - 50) / 5.0 + 2);
                edges[i].add(new Edge(j, Math.min(byWalking, byCannon)));
            }
        }

        dijkstra(0);

        bw.write(time[n + 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        time[start] = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            // 이미 방문한 대포일시 다시 갈 필요가 없음
            if (visited[e.next]) continue;
            visited[e.next] = true;

            for (Edge next : edges[e.next]) {
                if (time[next.next] < time[e.next] + next.cost) continue;

                // 다음장소까지 걸리는 시간 = 현재 장소까지 걸린 시간 + 다음 장소까지 걸리는 시간
                time[next.next] = time[e.next] + next.cost;
                pq.add(new Edge(next.next, time[next.next]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
