import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int n, m;
    static int[] parent;
    static int[][] map;
    static int islandCount;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> islandList;
    static PriorityQueue<Edge> edges;

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        // 섬 분리 및 번호 부여
        islandCount = 0;
        islandList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    bfs(i, j);
                }
            }
        }

        // 다리 생성
        edges = new PriorityQueue<>();
        generateBridges();

        // 크루스칼 알고리즘으로 MST 구성
        parent = new int[islandCount + 1];
        for (int i = 0; i <= islandCount; i++) {
            parent[i] = i;
        }
        
        int useEdge = 0;
        int answer = 0;
        
        while (!edges.isEmpty()) {
            Edge cur = edges.poll();
            if (find(cur.from) != find(cur.to)) {
                union(cur.from, cur.to);
                answer += cur.cost;
                useEdge++;
            }
        }

        if (useEdge == islandCount - 1) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> currentIsland = new ArrayList<>();
        
        q.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandCount;
        currentIsland.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = islandCount;
                        q.add(new int[]{nextX, nextY});
                        currentIsland.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        
        islandList.add(currentIsland);
    }

    static void generateBridges() {
        for (int i = 0; i < islandList.size(); i++) {
            ArrayList<int[]> curList = islandList.get(i);
            
            for (int[] pos : curList) {
                int curX = pos[0];
                int curY = pos[1];
                int islandNum = map[curX][curY];

                for (int d = 0; d < 4; d++) {
                    int nextX = curX + dx[d];
                    int nextY = curY + dy[d];
                    int bridgeLength = 0;

                    while (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                        if (map[nextX][nextY] == islandNum) {
                            break;
                        } else if (map[nextX][nextY] != 0) {
                            if (bridgeLength >= 2) {
                                edges.add(new Edge(islandNum, map[nextX][nextY], bridgeLength));
                            }
                            break;
                        } else {
                            bridgeLength++;
                        }
                        
                        nextX += dx[d];
                        nextY += dy[d];
                    }
                }
            }
        }
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
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }
}