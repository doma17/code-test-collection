import java.util.*;
public class Main {

    static int[] dr = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 1, -1, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        // 1부터 nxn의 위치를 저장 (인덱스가 해당 숫자) [r, c]
        int[][] loc = new int[n * n + 1][2]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                loc[grid[i][j]][0] = i;
                loc[grid[i][j]][1] = j;
            }
        }
        
        while (m-- > 0) {
            for (int i = 1; i <= n * n; i++) {
                int r = loc[i][0];
                int c = loc[i][1];

                int changeValue = 0;
                int cR = r;
                int cC = c;
                for (int j = 0; j < 8; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

                    if (grid[nr][nc] > changeValue) {
                        changeValue = grid[nr][nc];
                        cR = nr;
                        cC = nc;
                    }
                }
                // grid, loc 교환
                int standardValue = grid[r][c];
                grid[r][c] = grid[cR][cC];
                grid[cR][cC] = standardValue;

                int tempR = loc[standardValue][0];
                int tempC = loc[standardValue][1];
                loc[standardValue][0] = cR;
                loc[standardValue][1] = cC;
                loc[grid[r][c]][0] = tempR;
                loc[grid[r][c]][1] = tempC;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(grid[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}