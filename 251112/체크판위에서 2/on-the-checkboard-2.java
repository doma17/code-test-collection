import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                String tmp = st.nextToken();
                map[i][j] = (tmp.equals("W")) ? 0 : 1;
            }
        }

        int answer = 0;
        int[][] dp = new int[R][C];
        dp[0][0] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int curColor = map[n.r][n.c];
            int curCount = n.count;

            for (int nextR = n.r + 1; nextR < R; nextR++) {
                for (int nextC = n.c + 1; nextC < C; nextC++) {
                    if (curCount == 2) {
                        if (nextR == R - 1 && nextC == C - 1 && map[nextR][nextC] != curColor) {
                            answer++;
                        }
                    } else if (map[nextR][nextC] != curColor) {
                        queue.add(new Node(nextR, nextC, curCount + 1));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int r;
        int c;
        int count;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}