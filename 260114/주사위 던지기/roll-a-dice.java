import java.util.*;

public class Main {

    // 윗면, 앞면, 오른쪽, 왼쪽, 뒷면, 아랫면
    static int[] dice = {1, 5, 3, 4, 2, 6};

    static int n, m, r, c;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        String[] directions = new String[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next();
        }
        
        map = new int[n][n];
        for (int i = 0; i < m; i++) {
            // 움직일때 아랫면 복사, 붙혀넣기
            map[r][c] = dice[5];
            if (directions[i].equals("L")) {
                // 범위를 벗어나면 제자리 유지
                if (moveLeft()) continue;
                c -= 1;
            } else if (directions[i].equals("R")) {
                if (moveRight()) continue;
                c += 1;
            } else if (directions[i].equals("U")) {
                if (moveUp()) continue;
                r -= 1;
            } else if (directions[i].equals("D")) {
                if (moveDown()) continue;;
                r += 1;
            }
        }
        map[r][c] = dice[5];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            } 
        }
        System.out.println(sum);
    }

    // 윗면, 앞면, 오른쪽, 왼쪽, 아랫면, 뒷면
    // static int[] dice = {1, 5, 3, 4, 2, 6};

    // 서
    private static boolean moveLeft() {
        // 이동 가능 판단
        if (c - 1 < 0) return true;
        int tmp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = tmp;
        return false;
    }
    
    // 동
    private static boolean moveRight() {
        if (c + 1 >= n) return true;
        int tmp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = tmp;
        return false;
    }

    // 북
    private static boolean moveUp() {
        if (r - 1 < 0) return true;
        int tmp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = tmp;
        return false;
    }

    // 남
    private static boolean moveDown() {
        if (r + 1 >= n) return true;
        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[4];
        dice[4] = tmp;
        return false;
    }
}