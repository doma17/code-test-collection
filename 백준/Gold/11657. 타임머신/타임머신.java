import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<Edge> list;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        
        list = new ArrayList<>();
        distance = new long[n + 1];

        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            list.add(new Edge(a, b, c));
        }

        bellmanFord(1);
    }

    static void bellmanFord(int start)throws IOException {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // 최소 거리 탐색
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = list.get(j);
                if (distance[edge.from] == Integer.MAX_VALUE) continue;
                else if (distance[edge.to] > distance[edge.from] + edge.cost) {
                    distance[edge.to] = distance[edge.from] + edge.cost;
                }
            }
        }

        // 음수 사이클 검증
        boolean negativeCycle = false;
        for (int i = 0; i < m; i++) {
            Edge edge = list.get(i);
            if (distance[edge.from] == Integer.MAX_VALUE) continue;
            else if (distance[edge.to] > distance[edge.from] + edge.cost) {
                negativeCycle = true;
            }
        }

        // Output
        if (!negativeCycle) {
            for (int i = 2; i <= n; i++) {    
                if (distance[i] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(distance[i] + "\n");
                }
            }
        } else {
            bw.write("-1\n");
        }
        bw.flush();
        bw.close();
    }

    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from =from;
            this.to = to;
            this.cost = cost;
        } 
    }
}