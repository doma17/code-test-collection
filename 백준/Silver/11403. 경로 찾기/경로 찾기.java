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
        n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i == j) {
                    matrix[i][i] = 0;
                } else {
                    matrix[i][j] = 100000001;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j].equals("1")) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        // Floyd
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == 1 && matrix[k][j] == 1) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        // Output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
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