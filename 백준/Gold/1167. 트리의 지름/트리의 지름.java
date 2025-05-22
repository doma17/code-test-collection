import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // Variable
    static int v;

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        // Init
        v = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, cost));
            }
        }

        visited = new boolean[v + 1];
        distance = new int[v + 1];
        BFS(1);
        int maxIndex = 1;
        for (int i = 2; i <= v; i++) {
            if (distance[maxIndex] < distance[i]) {
                maxIndex = i;
            }
        }
        
        visited = new boolean[v + 1];
        distance = new int[v + 1];
        BFS(maxIndex);
        Arrays.sort(distance);
        System.out.println(distance[v]);
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cnt = queue.poll();

            for (Node next : list[cnt]) {
                int nextNode = next.b;
                int nextCost = next.cost;

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    distance[nextNode] = distance[cnt] + nextCost;
                }
            }
        }
    }

    static class Node {
        public int b;
        public int cost;

        public Node(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }
    }
}