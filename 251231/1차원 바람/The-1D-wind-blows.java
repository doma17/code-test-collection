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
            cacluateWind(r - 1, d);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(a[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void cacluateWind(int r, char d) {
        int[] dirs = new int[n];
        dirs[r] = (d == 'L' ? 1 : -1);

        for (int i = r; i > 0; i--) {
            if (dirs[i] == 0) break;

            boolean isSame = false;
            for (int c = 0; c < m; c++) {
                if (a[i][c] == a[i - 1][c]) {
                    isSame = true;
                    break;
                }
            }

            if (isSame) {
                dirs[i - 1] = -dirs[i];
            } else {
                break;
            }
        }

        for (int i = r; i < n - 1; i++) {
            if (dirs[i] == 0) break;

            boolean isSame = false;
            for (int c = 0; c < m; c++) {
                if (a[i][c] == a[i + 1][c]) {
                    isSame = true;
                    break;
                }
            }

            if (isSame) {
                dirs[i + 1] = -dirs[i];
            } else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (dirs[i] == 1) {
                windLeft(i);
            } else if (dirs[i] == -1) {
                windRight(i);
            }
        }
    }

    private static void windLeft(int r) {
        int temp = a[r][m - 1];
        for (int i = m - 1; i > 0; i--) {
            a[r][i] = a[r][i - 1];
        }
        a[r][0] = temp;
    }

    private static void windRight(int r) {
        int temp = a[r][0];
        for (int i = 0; i < m - 1; i++) {
            a[r][i] = a[r][i + 1];
        }
        a[r][m - 1] = temp;
    }
}