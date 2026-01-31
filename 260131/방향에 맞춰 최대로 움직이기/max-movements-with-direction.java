import java.util.Scanner;
public class Main {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    static int n;
    static int[][] num;
    static int[][] moveDir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt() - 1;
            }
        }
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        
        move(0, r, c);
        System.out.println(answer);
    }

    static int answer = 0;

    private static void move(int count, int r, int c) {
        boolean isMoved = false;
        for (int i = 1; i <= n; i++) {
            int nr = r + dr[moveDir[r][c]] * i;
            int nc = c + dc[moveDir[r][c]] * i;

            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
            if (num[nr][nc] <= num[r][c]) continue;

            isMoved = true;
            move(count + 1, nr, nc);
        }
        if (isMoved == false)
            answer = Math.max(answer, count);
    }
}