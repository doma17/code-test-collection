import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        // Process
        for (int i = 1; i <= n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (tmp[j - 1].equals("1")) {
                    union(i, j);
                }
            }
        }

        // Output
        String[] tmp = br.readLine().split(" ");
        int root = find(Integer.parseInt(tmp[0]));
        for (String x : tmp) {
            if (root != find(Integer.parseInt(x))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);  // 경로 압축
        }
        return parents[x];
    }

    static void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX != pY) {
            parents[pY] = pX;
        }
    }
}