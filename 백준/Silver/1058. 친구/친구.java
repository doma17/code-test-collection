import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    int[][] matrix;
    int n;
    int maxFriend = -1;

    public void solution() throws Exception {
        // INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];

        for (int[] m : matrix)
            Arrays.fill(m, 100000000);
        for (int i = 0; i < n; i++)
            matrix[i][i] = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if ('Y' == s.charAt(j)) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 100000000;
                }
            }
        }

        // PROCESS
        floyd();

        // OUTPUT
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // 2-친구는 A와 B가 서로 친구이거나, A와 친구이고, B와 친구인 C가 존재해야한다.
                // 즉 1, 2의 친구가 가장 많은 사람의 친구수를 반환하면 된다.
                if (matrix[i][j] == 2 || matrix[i][j] == 1)
                    cnt++;
            }
            maxFriend = Math.max(maxFriend, cnt);
        }

        sb.append(maxFriend);

        bw.write(sb.toString());
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
