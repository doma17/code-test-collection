import java.util.Scanner;
public class Main {

    static int n, m, q;
    static int[][] building;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        building = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt() - 1;

        
        for (int x = 0; x < q; x++) {
            rotate(queries[x][0], queries[x][1], queries[x][2], queries[x][3]);
            building = calAllAverage(queries[x][0], queries[x][1], queries[x][2], queries[x][3]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(building[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

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