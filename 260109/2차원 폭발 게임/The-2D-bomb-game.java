import java.util.*;
import java.io.*; // BufferedReader, InputStreamReader 등을 위해 추가

public class Main {

    static int n, m, k;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringTokenizer를 사용한 빠른 입력 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < k; i++) {
            while (bomb()) {
                gravity();
            }
            pivot();
            gravity();
        }
        while (bomb()) {                
            gravity();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) answer++;
            }
        }
        System.out.println(answer);
    }

    // 폭탄 터지기 로직
    private static boolean bomb() {
        boolean isExploded = false;
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n) {
                if (grid[i][j] == 0) {
                    i++;
                    continue;
                }
                int end = i + 1;
                while (end < n && grid[end][j] == grid[i][j]) {
                    end++;
                }

                if (end - i >= m) {
                    isExploded = true;
                    for (int x = i; x < end; x++){
                        grid[x][j] = 0;
                    }
                }
                i = end;
            }
        }
        return isExploded;
    }

    // 중력 로직
    private static void gravity() {
        int[][] tmp = new int[n][n];
        for (int j = 0; j < n; j++) {
            int idx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    tmp[idx--][j] = grid[i][j];
                }
            }
        }
        grid = tmp;
    }

    // 피봇 (90도 시계방향 회전)
    private static void pivot() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[j][n - 1 - i] = grid[i][j];
            }
        } 
        grid = tmp;
    }
}