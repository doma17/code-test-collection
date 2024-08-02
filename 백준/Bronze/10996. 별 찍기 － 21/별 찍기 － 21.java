import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public void solution() throws Exception {
        // INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < n / 2 + n % 2; i++) {
            a.append("* ");
        }
        a.append("\n");
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            b.append(" *");
        }
        b.append("\n");

        a.append(b);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(a);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
