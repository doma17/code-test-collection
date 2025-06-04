import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Node>[] arr;
    static boolean[] visited;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList[n];
        visited = new boolean[n];
        distance = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Node>();
        }
        
        long lcm = 1;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, p, q));
            arr[b].add(new Node(a, q, p));
            lcm *= p * q / gcd(p, q); // 모든 비율의 최소 공배수 저장
        }

        // 임의 노드에 저장
        distance[0] = lcm;
        dfs(0);

        // 모든 칵테일 재료의 최대공약수 구하기
        long result = distance[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, distance[i]);
        }

        // 재료 / 최대공약수 -> 최소 비율
        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] / result + " ");
        }
        System.out.println();
    }

    // 모든 재료를 순환하면서 q / p의 비율로 곱함.
    private static void dfs(int index) {
        visited[index] = true;
        for (var node : arr[index]) {
            int next = node.getB();
            if (!visited[next]) {
                distance[next] = distance[index] * node.getQ() / node.getP();
                dfs(next);
            }
        }
    }

    private static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
 }