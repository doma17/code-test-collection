import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int v, e;
    static int[] parent;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        v = Integer.parseInt(tmp[0]);
        e = Integer.parseInt(tmp[1]);

        edges = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            edges.add(new Edge(x, y, c));
        }

        parent = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }

        long answer = 0;
        int used = 0;
        while (used < v - 1) {
            Edge e = edges.poll();
            int x = e.from;
            int y = e.to;

            if (find(x) != find(y)) {
                union(x, y);
                answer += e.cost;
                used++;
            }
        }

        System.out.println(answer);
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost < e.cost ? -1 : 1;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}