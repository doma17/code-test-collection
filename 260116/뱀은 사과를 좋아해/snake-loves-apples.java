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

        // 사과 : -1, 뱀머리 : 1
        dp = new int[n][n];
        dp[0][0] = 1;

        // 사과위치 입력
        for (int i = 0; i < m; i++) {
            dp[sc.nextInt() - 1][sc.nextInt() - 1] = -1;
        }

        // 뱀머리 초기위치
        int x = 0;
        int y = 0;
        int t = 0;

        int head = 1;

        int tail = 1;
        int tx = 0, ty = 0;

        for (int i = 0; i < k; i++) {
            boolean isEnd = false;
            char d = sc.next().charAt(0); // 방향
            int p = sc.nextInt(); // 얼마나 갈지 : 거리

            // 방향 선정
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
                
                if (dp[nx][ny] > 0 && dp[nx][ny] != tail) { 
                    isEnd = true;
                    break;
                }

                if (dp[nx][ny] == -1) {
                    head++;
                    dp[nx][ny] = head;
                } else {
                    head++;
                    dp[nx][ny] = head;
                    
                    dp[tx][ty] = 0;
                    tail++;

                    // 다음 꼬리 찾기
                    boolean foundTail = false;
                    for (int k = 0; k < 4; k++) {
                        int ntx = tx + dx[k];
                        int nty = ty + dy[k];

                        if (ntx < 0 || ntx >= n || nty < 0 || nty >= n) continue;

                        if (dp[ntx][nty] == tail) {
                            tx = ntx;
                            ty = nty;
                            foundTail = true;
                            break;
                        }
                    }
                    if (!foundTail) { // 꼬리 못찾을떄 길이가 1이어서 그럼
                        tx = nx;
                        ty = ny;
                    }
                }
                x = nx;
                y = ny;
            }
            if (isEnd) break;
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }

        // 몇초까지 생존
        System.out.println(t);
    }  
}