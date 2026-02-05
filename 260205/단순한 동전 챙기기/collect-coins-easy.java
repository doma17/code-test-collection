import java.util.*;
public class Main {

    static int N;
    static String[] grid;

    static boolean[][] visited;

    static int startR = -1;
    static int startC = -1;
    static int endR = -1;
    static int endC = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                } else if (grid[i].charAt(j) == 'E') {
                    endR = i;
                    endC = j;
                }
            }
        }

        visited[startR][startC] = true;
        move(startR, startC, 0, 0, 0);
        
        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    static int answer = Integer.MAX_VALUE;

    private static void move(int r, int c, int lastCoinValue, int coinCount, int count) {
        if (r == endR && c == endC) {
            if (coinCount >= 3)
                answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) == '.') continue;
                if (grid[i].charAt(j) == 'E') {
                    move(i, j, lastCoinValue, coinCount, count + Math.abs(r - i) + Math.abs(c - j));
                    continue;
                }
                if (!visited[i][j]) { // 동전 위치 방문했는지 확인
                    int targetCoin = grid[i].charAt(j) - '0';
                    if (targetCoin > lastCoinValue) {
                        // 안방문했으면 lastCoinValue 바꾸고, coinCount++, count는 맨하튼 거리 더하기
                        visited[i][j] = true;
                        move(i, j, targetCoin, coinCount + 1, count + Math.abs(r - i) + Math.abs(c - j));
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
}