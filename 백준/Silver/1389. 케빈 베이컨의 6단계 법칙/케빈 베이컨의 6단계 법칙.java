import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);

        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++){
                if (i == j) {
                    matrix[i][i] = 0;
                } else {
                    matrix[i][j] = 100000001;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        // Floyd
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // Output
        int minSum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += matrix[i][j];
            }
            if (minSum > sum) {
                minSum = sum;
                index = i;
            }
        }
        System.out.println(index);
    }
}