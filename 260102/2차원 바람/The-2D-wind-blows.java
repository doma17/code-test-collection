import java.io.*;
import java.util.*;

public class Main {

    static int n, m, q;
    static int[][] building;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        building = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                building[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            rotate(r1, c1, r2, c2);
            building = calAllAverage(r1, c1, r2, c2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(building[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[][] calAllAverage(int r1, int c1, int r2, int c2) {
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) result[i][j] = building[i][j];
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                result[i][j] = getAverage(i, j);
            }
        }
        return result;
    }

    private static int getAverage(int r, int c) {
        int sum = building[r][c];
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;

            sum += building[nextR][nextC];
            cnt++;
        }
        return sum / cnt;
    }

    private static void rotate(int r1, int c1, int r2, int c2) {
        int temp = building[r1][c1];
        for (int i = r1; i < r2; i++) {
            building[i][c1] = building[i + 1][c1];
        }
        for (int i = c1; i < c2; i++) {
            building[r2][i] = building[r2][i + 1];
        }
        for (int i = r2; i > r1; i--) {
            building[i][c2] = building[i - 1][c2];
        }
        for (int i = c2; i > c1; i--) {
            building[r1][i] = building[r1][i - 1];
        }
        building[r1][c1 + 1] = temp;
    }
}