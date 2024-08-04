import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int a, b, c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    final long MAX_INT = 2000000000;
    int n, m;
    ArrayList<Edge> edges;
    long[] distance;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        distance = new long[n + 1];
        Arrays.fill(distance, MAX_INT);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        distance[1] = 0;
        boolean infinite = false;

        for (int i = 1; i <= n; i++) {
            for (Edge e : edges) {
                if (distance[e.a] == MAX_INT) continue;
                if (distance[e.b] > distance[e.a] + e.c) {
                    distance[e.b] = distance[e.a] + e.c;
                    if (i == n) infinite = true;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (infinite) {
            bw.write("-1\n");
        } else {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == MAX_INT) {
                    bw.write("-1\n");
                } else {
                    bw.write(distance[i] + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
