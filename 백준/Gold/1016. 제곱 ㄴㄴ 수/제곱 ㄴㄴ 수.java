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
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] A = new boolean[(int)(max - min + 1)];

        for (long i = 2; i * i <=  max; i++) {
            long pow = i * i;
            long start = (min + pow - 1) / pow;
            for (long j = start; pow * j <= max; j++) {
                A[(int)((j * pow) - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!A[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
 }