import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int r, c, w, d, id;

        public Node(int r, int c, int w, int d, int id) {
            this.r = r;
            this.c = c;
            this.w = w;
            this.d = d;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            if (this.w != o.w) return this.w - o.w;
            return this.id - o.id;
        }
    }

    static int getDirection(char c) {
        if (c == 'U') return 0;
        if (c == 'D') return 1;
        if (c == 'R') return 2;
        if (c == 'L') return 3;
        return -1;
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int MAX_SIZE = 4005;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        for (int tc = 1; tc <= t; tc++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line == null) break;
            
            int n = Integer.parseInt(line.trim());
            ArrayList<Node> nodeList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int w = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);
                nodeList.add(new Node(y, x, w, getDirection(d), i + 1));
            }
            
            int answer = -1;
            Node[][] map = new Node[MAX_SIZE][MAX_SIZE];

            for (int i = 0; i <= 4002; i++) {
                for (Node node : nodeList) {
                    node.r += dr[node.d];
                    node.c += dc[node.d];
                }

                boolean crash = false;
                for (Node node : nodeList) {
                    if (node.r < 0 || node.r >= MAX_SIZE || node.c < 0 || node.c >= MAX_SIZE) continue;
                    
                    if (map[node.r][node.c] == null) {
                        map[node.r][node.c] = node;
                    } else {
                        crash = true;
                        if (node.compareTo(map[node.r][node.c]) > 0) {
                            map[node.r][node.c] = node;
                        }
                    }
                }

                ArrayList<Node> nextNodeList = new ArrayList<>();
                for (Node node : nodeList) {
                    if (node.r < 0 || node.r >= MAX_SIZE || node.c < 0 || node.c >= MAX_SIZE) continue;
                    
                    if (map[node.r][node.c] != null) {
                        nextNodeList.add(map[node.r][node.c]);
                        map[node.r][node.c] = null;
                    }
                }
                nodeList = nextNodeList;

                if (crash) answer = i + 1;
                if (nodeList.isEmpty()) break;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}