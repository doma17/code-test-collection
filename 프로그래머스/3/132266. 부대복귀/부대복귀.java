import java.util.*;

class Solution {
    
    // 지역 개수
    int N;
    // 부대원 위치
    int[] Sources;
    // 지역 이동 간선
    ArrayList<Integer>[] edges;
    // 지역 별 거리
    int[] distance;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        Sources = sources;

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (var road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
        }
        
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[destination] = 0;
        
        bfs(destination);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = (distance[sources[i]] == Integer.MAX_VALUE) ? -1 : distance[sources[i]];
        }
        return answer;
    }
    
    // 다익스트라
    private void bfs(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNum = cur.num;
            int curCost = cur.cost;
            
            if (curCost > distance[curNum]) continue;
            
            for (var next : edges[curNum]) {
                if (distance[next] > curCost + 1) {
                    distance[next] = curCost + 1;
                    pq.add(new Node(next, distance[next]));
                }
            }
        }
    }
    
    class Node implements Comparable<Node> {
        int num;
        int cost;
        
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}