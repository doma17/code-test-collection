import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] grid = new int[N][N];
            int[][] count = new int[N][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                char d = st.nextToken().charAt(0);

                int dir = 0;
                switch (d) {
                    case 'U': dir = 1; break;
                    case 'D': dir = 2; break;
                    case 'R': dir = 3; break;
                    case 'L': dir = 4; break;
                }

                grid[r][c] = dir;
                count[r][c]++;
            }

            int time = N * 2;
            while (time-- > 0) {
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
                        if (tmpCount[r][c] > 1) {
                            tmpGrid[r][c] = 0;
                            tmpCount[r][c] = 0;
                        }
                    }
                }
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