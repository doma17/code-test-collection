import java.io.*;
import java.util.*;

class Main {

    private class Edge implements Comparable<Edge>{

        int end, relation;

        public Edge(int end, int relation) {
            this.end = end;
            this.relation = relation;
        }

        @Override
        public int compareTo(Edge o) {
            return this.relation - o.relation;
        }
    }

    int t;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<Edge>[] edges = new ArrayList[m];
            for (int j = 0; j < m; j++)
                edges[j] = new ArrayList<>();

            int[] relationScore = new int[m];
            Arrays.fill(relationScore, Integer.MAX_VALUE);
            int[] backTrace = new int[m];
            Arrays.fill(backTrace, -1);

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                edges[x].add(new Edge(y, z));
                edges[y].add(new Edge(x, z));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(0, 0));
            relationScore[0] = 0;

            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                for (Edge next : edges[now.end]) {
                    int nextRelation = now.relation + next.relation;

                    if (relationScore[next.end] > nextRelation) {
                        backTrace[next.end] = now.end;
                        relationScore[next.end] = nextRelation;
                        pq.add(new Edge(next.end, nextRelation));
                    }
                }
            }

            bw.write("Case #" + (i + 1) + ": ");
            if (relationScore[m - 1] == Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                LinkedList<Integer> path = new LinkedList<>();

                int index = m - 1;
                while (index != -1) {
                    path.addFirst(index);
                    index = backTrace[index];
                }

                if (path.getFirst() != 0) {
                    bw.write("-1\n"); // 경로가 0번에서 시작하지 않는 경우 잘못된 경로이므로 -1 출력
                } else {
                    for (int node : path) {
                        bw.write(node + " ");
                    }
                    bw.write("\n");
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
