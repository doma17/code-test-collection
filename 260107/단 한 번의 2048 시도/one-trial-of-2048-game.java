import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);
        
        if (dir == 'L') {
            for (int r = 0; r < 4; r++) {
                int[] arr = new int[4];
                for (int c = 0; c < 4; c++) {
                    arr[c] = grid[r][c];
                }

                int[] result = mergeArr(arr);
                for (int c = 0; c < 4; c++) {
                    grid[r][c] = result[c];
                }
            }
        } else if (dir == 'R') {
            for (int r = 0; r < 4; r++) {
                int[] arr = new int[4];
                for (int c = 0; c < 4; c++) {
                    arr[c] = grid[r][3 - c];
                }

                int[] result = mergeArr(arr);
                for (int c = 0; c < 4; c++) {
                    grid[r][3 - c] = result[c];
                }
            }
        } else if (dir == 'U') {
            for (int c = 0; c < 4; c++) {
                int[] arr = new int[4];
                for (int r = 0; r < 4; r++) {
                    arr[r] = grid[3 - r][c];
                }

                int[] result = mergeArr(arr);
                for (int r = 0; r < 4; r++) {
                    arr[r] = grid[3 - r][c];
                }
            }
        } else if (dir == 'D') {
            for (int c = 0; c < 4; c++) {
                int[] arr = new int[4];
                for (int r = 0; r < 4; r++) {
                    arr[r] = grid[r][c];
                }

                int[] result = mergeArr(arr);
                for (int r = 0; r < 4; r++) {
                    arr[r] = grid[r][c];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(grid[i][j] + " ");
            }
            if (i + 1 != 4) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[] mergeArr(int[] arr) {
        int[] tmp = new int[4];
        int idx = 0;

        for (int i = 0; i < 4; i++) {
            if (arr[i] != 0) tmp[idx++] = arr[i];
        }

        for (int i = 0; i < 3; i++) {
            if (tmp[i] == 0) continue;
            else if (tmp[i] == tmp[i + 1]) {
                tmp[i] += tmp[i];
                tmp[i + 1] = 0;
            } 
        }

        int[] result = new int[4];
        idx = 0;
        for (int i = 0; i < 4; i++) {
            if (tmp[i] != 0) result[idx++] = tmp[i];
        }
        return result;
    }
}