import java.util.Scanner;

public class Main {

    static int n, m, k;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        dp = new int[n][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            dp[sc.nextInt() - 1][sc.nextInt() - 1] = -1;
        }

        int x = 0;
        int y = 0;
        int t = 0;

        int head = 1;
        int tail = 1;
        int tx = 0, ty = 0;

        boolean isEnd = false;

        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();

            int dir = 0;
            if (d == 'U') dir = 0;
            else if (d == 'D') dir = 1;
            else if (d == 'L') dir = 2;
            else if (d == 'R') dir = 3;

            for (int j = 0; j < p; j++) {
                t++;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    isEnd = true;
                    break;
                }

                boolean isApple = dp[nx][ny] == -1;

                if (!isApple) {
                    dp[tx][ty] = 0;
                    tail++;

                    boolean foundTail = false;
                    for (int l = 0; l < 4; l++) {
                        int ntx = tx + dx[l];
                        int nty = ty + dy[l];

                        if (ntx < 0 || ntx >= n || nty < 0 || nty >= n) continue;

                        if (dp[ntx][nty] == tail) {
                            tx = ntx;
                            ty = nty;
                            foundTail = true;
                            break;
                        }
                    }
                    if (!foundTail) {
                        tx = nx;
                        ty = ny;
                    }
                }

                if (dp[nx][ny] > 0) {
                    isEnd = true;
                    break;
                }

                head++;
                dp[nx][ny] = head;
                x = nx;
                y = ny;
            }
            if (isEnd) break;
        }

        System.out.println(t);
    }
}