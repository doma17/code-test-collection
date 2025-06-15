import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] indegree;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static int startCity, endCity;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] tmp = br.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
            indegree[to]++;
        }

        String[] tmp = br.readLine().split(" ");
        startCity = Integer.parseInt(tmp[0]);
        endCity = Integer.parseInt(tmp[1]);

        // Process
        topologySort();
    }

    public static void topologySort() {
        // 1. 위상정렬로 최장 경로 구하기
        Queue<Integer> q = new LinkedList<>();
        int[] maxTime = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node next : graph[now]) {
                indegree[next.index]--;
                maxTime[next.index] = Math.max(maxTime[next.index], maxTime[now] + next.cost);
                if (indegree[next.index] == 0) {
                    q.offer(next.index);
                }
            }
        }

        // 2. 임계 경로 개수 구하기
        int criticalEdges = 0;
        boolean[] visited = new boolean[n + 1];
        
        criticalEdges = countEdges(endCity, maxTime, visited);

        // Output
        System.out.println(maxTime[endCity]);
        System.out.println(criticalEdges);
    }

    /**
     * DFS로 임계 경로 역추적  
     */ 
    private static int countEdges(int city, int[] maxTime, boolean[] visited) {
        if (visited[city]) {
            return 0;
        }
        visited[city] = true;
        
        int count = 0;
        
        for (Node next : reverseGraph[city]) {
            if (maxTime[next.index] + next.cost == maxTime[city]) {
                count++;
                count += countEdges(next.index, maxTime, visited);
            }
        }
        
        return count;
    }

    static class Node {
        public int cost;
        public int index;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}