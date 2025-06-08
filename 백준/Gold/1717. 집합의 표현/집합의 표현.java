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
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            if (tmp[0].equals("0")) { // 합집합
                int a = Integer.parseInt(tmp[1]);
                int b = Integer.parseInt(tmp[2]);
                union(a, b);
            } else { // 같은 집합인지 확인
                int a = Integer.parseInt(tmp[1]);
                int b = Integer.parseInt(tmp[2]);
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    static void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        parents[pY] = pX;
    }

    // 최상위 노드 검색
    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return find(parents[x]);
    }
 }