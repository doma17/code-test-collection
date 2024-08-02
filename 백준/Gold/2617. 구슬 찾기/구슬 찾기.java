import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    final int MAX_INT = 100000000;
    int[][] matrix;
    int n;
    int m;

    public void solution() throws Exception {
        // INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][n];

        for (int[] m : matrix)
            Arrays.fill(m, MAX_INT);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            matrix[a][b] = 1;
        }
        
        floyd();

        int answer = 0;
        int[] row = new int[n];
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (matrix[i][j] == MAX_INT) continue;

                row[i]++;
                col[j]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (row[i] >= (n + 1) / 2) answer++;
            if (col[i] >= (n + 1) / 2) answer++;
        }
        
        // OUTPUT
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
