import java.util.Scanner;

public class Main {

    static int n, m, q;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        a = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);
            calculateWind(r - 1, d == 'L' ? 1 : -1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(a[i][j] + " ");
            }
            if (i != n - 1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void calculateWind(int r, int dir) {
        shift(r, dir);

        int currDir = dir;
        for (int i = r; i > 0; i--) {
            if (hasSameNumber(i, i - 1)) {
                currDir = -currDir;
                shift(i - 1, currDir);
            } else {
                break;
            }
        }

        currDir = dir;
        for (int i = r; i < n - 1; i++) {
            if (hasSameNumber(i, i + 1)) {
                currDir = -currDir;
                shift(i + 1, currDir);
            } else {
                break;
            }
        }
    }

    private static boolean hasSameNumber(int r1, int r2) {
        for (int i = 0; i < m; i++) {
            if (a[r1][i] == a[r2][i]) return true;
        }
        return false;
    }

    private static void shift(int r, int dir) {
        if (dir == 1) {
            int temp = a[r][m - 1];
            for (int i = m - 1; i > 0; i--) {
                a[r][i] = a[r][i - 1];
            }
            a[r][0] = temp;
        } else {
            int temp = a[r][0];
            for (int i = 0; i < m - 1; i++) {
                a[r][i] = a[r][i + 1];
            }
            a[r][m - 1] = temp;
        }
    }
}