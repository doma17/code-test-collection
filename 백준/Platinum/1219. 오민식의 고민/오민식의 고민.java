import java.io.*;
import java.util.*;

class Main {

    class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    int n, m, start, end;
    long[] distance;
    int[] city;
    ArrayList<Edge> edges;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n];
        Arrays.fill(distance, Long.MIN_VALUE);

        city = new int[n];
        edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, -c));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        distance[start] = city[start];

        // Bellman-Ford 알고리즘
        for (int i = 0; i < n * 2; i++) {
            for (Edge e : edges) {
                if (distance[e.start] == Long.MAX_VALUE)
                    distance[e.end] = Long.MAX_VALUE;
                else if (distance[e.start] != Long.MIN_VALUE && distance[e.end] < distance[e.start] + e.cost + city[e.end]) {
                    if (i >= n)
                        distance[e.end] = Long.MAX_VALUE;
                    else
                        distance[e.end] = distance[e.start] + e.cost + city[e.end];
                }
            }
        }

        if (distance[end] == Long.MIN_VALUE) bw.write("gg\n");
        else if (distance[end] == Long.MAX_VALUE) bw.write("Gee\n");
        else bw.write(distance[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
