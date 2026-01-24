import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int r, c, d, v, id;

        public Node(int r, int c, int d, int v, int id) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.v = v;
            this.id = id;
        }

        // 우선 순위 = 속도 빠름, 번호 큼
        @Override
        public int compareTo(Node o) {
            if (this.v != o.v) return o.v - this.v;
            return o.id - this.id;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char d = st.nextToken().charAt(0);
            int v = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(r, c, getDirection(d), v, i + 1));
        }

        while (T-- > 0) {
            ArrayList<Node>[][] map = new ArrayList[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = new ArrayList<>();
                }
            }

            for (Node n : nodeList) {
                int nr = n.r + dr[n.d] * n.v;
                int nc = n.c + dc[n.d] * n.v;

                // 상하 벽에 부딪힐때
                while (nr < 0 || nr >= N) {
                    if (nr < 0) {
                        nr = -nr;
                        n.d = 1;
                    } else {
                        nr = 2 * (N - 1) - nr;
                        n.d = 0;
                    }
                }
                // 좌우 벽에 부딪힐때
                while (nc < 0 || nc >= N) {
                    if (nc < 0) {
                        nc = -nc;
                        n.d = 2;
                    } else {
                        nc = 2 * (N - 1) - nc;
                        n.d = 3;
                    }
                }
                n.r = nr;
                n.c = nc;
                map[nr][nc].add(n);
            }

            ArrayList<Node> nextNodeList = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c].isEmpty()) 
                        continue;

                    if (map[r][c].size() > K) {
                        Collections.sort(map[r][c]);
                        
                        for (int i = 0; i < K; i++) {
                            nextNodeList.add(map[r][c].get(i));
                        }
                    } else {
                        nextNodeList.addAll(map[r][c]);
                    }
                }
            }
            nodeList = nextNodeList;
        }

        System.out.println(nodeList.size());
    }

    static int getDirection(char c) {
        if (c == 'U') return 0;
        if (c == 'D') return 1;
        if (c == 'R') return 2;
        if (c == 'L') return 3;
        return -1;
    }
}