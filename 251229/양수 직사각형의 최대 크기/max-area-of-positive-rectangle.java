import java.util.Scanner;
public class Main {

    static int n;
    static int m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = -1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                answer = Math.max(answer, getSizePositiveRentangle(r, c));
            }
        }
        System.out.println(answer);
    }

    private static int getSizePositiveRentangle(int r, int c) {
        int maxSize = -1;
        for (int r1 = r; r1 < n; r1++) {
            for (int c1 = c; c1 < m; c1++) {
                
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = c1; c2 < m; c2++) {
                        int size = 0;
                        boolean isPositiveAll = true;
                        for (int i = r1; i <= r2; i++) {
                            if (!isPositiveAll) break;
                            for (int j = c1; j <= c2; j++) {
                                if (grid[i][j] > 0) {
                                    size++;
                                } else {
                                    isPositiveAll = false;
                                    break;
                                }
                            }
                        }
                        if (!isPositiveAll) continue;
                        maxSize = Math.max(maxSize, size);
                    }
                }
            }
        }
        return maxSize;
    }
}