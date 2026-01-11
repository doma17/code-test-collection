import java.util.Scanner;
public class Main {

    static int n, r, c;
    static int[][] grid;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(grid[r][c]).append(" ");

        while (true) {
            int maxValue = -1;
            boolean next = false;
            int targetR = 0;
            int targetC = 0;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 1 || nr > n || nc < 1 || nc > n)
                    continue;
                
                if (grid[nr][nc] > grid[r][c]) {
                    maxValue = grid[nr][nc];
                    targetR = nr;
                    targetC = nc;
                    next = true;
                    break;
                }
            }
            if (next) {
                sb.append(maxValue).append(" ");
                r = targetR;
                c = targetC;
            } else {
                break;
            }
        }
        System.out.println(sb);
    }
}