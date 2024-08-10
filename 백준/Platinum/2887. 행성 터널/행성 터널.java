import java.io.*;
import java.util.*;

class Main {

    int n;

    ArrayList<int[]> X = new ArrayList<>();
    ArrayList<int[]> Y = new ArrayList<>();
    ArrayList<int[]> Z = new ArrayList<>();

    ArrayList<int[]> edges = new ArrayList<>();
    int[] parent;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            X.add(new int[]{x, i});
            Y.add(new int[]{y, i});
            Z.add(new int[]{z, i});
        }

        X.sort(Comparator.comparingInt(a -> a[0]));
        Y.sort(Comparator.comparingInt(a -> a[0]));
        Z.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n - 1; i++) {
            edges.add(new int[]{Math.abs(X.get(i)[0] - X.get(i + 1)[0]), X.get(i)[1], X.get(i + 1)[1]});
            edges.add(new int[]{Math.abs(Y.get(i)[0] - Y.get(i + 1)[0]), Y.get(i)[1], Y.get(i + 1)[1]});
            edges.add(new int[]{Math.abs(Z.get(i)[0] - Z.get(i + 1)[0]), Z.get(i)[1], Z.get(i + 1)[1]});
        }
        edges.sort(Comparator.comparingInt(a -> a[0]));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        long answer = 0;
        for (int[] edge : edges) {
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];

            if (union(a, b)) {
                answer += cost;
            }
        }
        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[a] = b;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
