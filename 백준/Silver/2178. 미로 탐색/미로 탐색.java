import java.io.*;
import java.util.*;

import javax.print.DocFlavor.STRING;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // Variable
    static int n;
    static int m;

    static int[][] matrix;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        // Init
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                matrix[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        // Process
        BFS(0, 0);
        System.out.println(matrix[n - 1][m - 1]);        
    }

    public static void BFS(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        while (!queue.isEmpty()) {
            int nowX = queue.peek().x;
            int nowY = queue.peek().y;
            queue.poll();
            visited[nowX][nowY] = true;

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (matrix[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                matrix[nextX][nextY] = matrix[nowX][nowY] + 1;
                queue.add(new Node(nextX, nextY));
            }
        }
    }

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}