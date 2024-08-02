import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    int[][] matrix;
    int n;
    int m;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];

        for (int[] m : matrix)
            Arrays.fill(m, 100000 * 1000);
        for (int i = 1; i <= n; i++)
            matrix[i][i] = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (matrix[a][b] == 100000 * 1000)
                matrix[a][b] = c;
            else
                matrix[a][b] = Math.min(matrix[a][b], c);
        }

        floyd();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = matrix[i][j];
                if (x == 100000 * 1000) x = 0;
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
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
