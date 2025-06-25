import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        int leftCable = 0;

        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int cost = charToCost(tmp[j]);
                if (cost == 0) {
                    continue;
                } else if (i == j) {
                    leftCable += cost;
                } else {
                    pq.add(new Edge(i, j, cost));
                }
            }
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int connectCount = 1;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                connectCount++;
            } else {
                leftCable += cur.cost;
            }
        }

        if (connectCount != n) {
            System.out.println(-1);
        } else {
            System.out.println(leftCable);
        }
    }

    static int charToCost(char c) {
        int tmp = 0;
        if (c >= 97) {
            tmp = c - 96;
        } else if (c >= 65) {
            tmp = c - 65 + 27;
        }
        return tmp;
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
            return Integer.compare(this.cost, e.cost);
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}