import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

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
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            if (matrix[x][y] > c) {
                matrix[x][y] = c;
            }
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
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i][j] == 100000001) {
                    bw.write("0 ");
                } else {
                    bw.write(matrix[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}