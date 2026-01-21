import java.util.Scanner;
public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][N];
            int[][] count = new int[N][N];
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                char d = sc.next().charAt(0);

                int dir = 0;
                switch (d) {
                    case 'U': dir = 1; break;
                    case 'D': dir = 2; break;
                    case 'R': dir = 3; break;
                    case 'L': dir = 4; break;
                }

                grid[x][y] = dir;
                count[x][y]++;
            }
            
            int x = N * 2;
            while (x-- > 0) {
                int[][] tmpGrid = new int[N][N];
                int[][] tmpCount = new int[N][N];
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        if (grid[r][c] == 0) continue;
                        int nr = r + dr[grid[r][c] - 1];
                        int nc = c + dc[grid[r][c] - 1];

                        if (nr < 0) {
                            tmpGrid[r][c] = 2;
                            tmpCount[r][c]++;
                            continue;
                        } else if (nr >= N) {
                            tmpGrid[r][c] = 1;
                            tmpCount[r][c]++;
                            continue;
                        } else if (nc < 0) {
                            tmpGrid[r][c] = 3;
                            tmpCount[r][c]++;
                            continue;
                        } else if (nc >= N) {
                            tmpGrid[r][c] = 4;
                            tmpCount[r][c]++;
                            continue;
                        }

                        tmpGrid[nr][nc] = grid[r][c];
                        tmpCount[nr][nc]++; 
                    }
                }

                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {
                        // System.out.print(tmpGrid[r][c] + " ");
                        if (tmpCount[r][c] > 1) {
                            tmpGrid[r][c] = 0;
                            tmpCount[r][c] = 0;
                        }
                    }
                    // System.out.println();
                }
                // System.out.println("---");
                grid = tmpGrid;
                count = tmpCount;
            }

            int answer = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++)
                    if (count[r][c] == 1) answer++;
            }
            System.out.println(answer);
        }
    }
}