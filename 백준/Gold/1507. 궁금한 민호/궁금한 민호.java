import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    int[][] matrix;
    int[][] result;
    int n;
    final int MAX_INT = 100000001;
    boolean contradiction = false;

    public void solution() throws Exception {
        // INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        result = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int[] m : matrix)
            Arrays.fill(m, MAX_INT);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());

                result[i][j] = matrix[i][j] = v;
            }
        }

        // PROCESS
        floyd();

        // OUTPUT

        // 모순
        if (contradiction) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (result[i][j] == MAX_INT) continue;
                if (visited[i][j]) continue;

                answer += result[i][j];
                visited[i][j] = visited[j][i] = true;
            }
        }

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
                    if (i == k || k == j) continue;
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        contradiction = true;
                        return;
                    }

                    if (matrix[i][j] == matrix[i][k] + matrix[k][j])
                        result[i][j] = MAX_INT;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
