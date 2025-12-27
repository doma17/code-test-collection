import java.util.Scanner;
public class Main {

    static int n;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int left = 1; left < n; left++) {
                    for (int right = 1; right < n; right++) {
                        // 가장 아래, 왼쪽 끝, 오른쪽 끝 꼭지점 범위 필터
                        if (r + left + right >= n || c - left < 0 || c + right >= n) continue;
                        answer = Math.max(answer, getSum(r, c, left, right));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static int getSum(int r, int c, int left, int right) {
        int sum = 0;
        int curR = r;
        int curC = c;

        // 왼쪽 아래
        for (int i = 0; i < left; i++) {
            curR++;
            curC--;
            sum += grid[curR][curC];
        }
        // 오른쪽 아래
        for (int i = 0; i < right; i++) {
            curR++;
            curC++;
            sum += grid[curR][curC];
        }
        // 오른쪽 위
        for (int i = 0; i < left; i++) {
            curR--;
            curC++;
            sum += grid[curR][curC];
        }
        // 왼쪽 위
        for (int i = 0; i < right; i++) {
            curR--;
            curC--;
            sum += grid[curR][curC];
        }

        return sum;
    }
}