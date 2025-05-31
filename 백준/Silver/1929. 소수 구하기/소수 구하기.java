import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] A = new int[n + 1];
        for (int i = 1; i < A.length; i++) {
            A[i] = i;
        }
        A[1] = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (A[i] != 0) {
                for (int j = i * 2; j < A.length; j += i) {
                    A[j] = 0;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (A[i] != 0) {
                System.out.println(i);
            }
        }
    }
}