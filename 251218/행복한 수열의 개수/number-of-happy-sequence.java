import java.util.Scanner;
  
public class Main {

    static int n;
    static int m;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += isSequenceRight(i);
            answer += isSequenceDown(i);
        }
        System.out.println(answer);
    }

    private static int isSequenceRight(int r) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (grid[r][i] == grid[r][i - 1]) {
                count++;
            } else {
                if (count >= m) 
                    return 1;
                count = 1;
            }
        }

        if (count >= m) return 1;
        return 0;
    }

    private static int isSequenceDown(int c) {
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (grid[i][c] == grid[i - 1][c]) {
                count++;
            } else {
                if (count >= m) 
                    return 1;
                count = 1;
            }
        }

        if (count >= m) return 1;
        return 0;
    }
}