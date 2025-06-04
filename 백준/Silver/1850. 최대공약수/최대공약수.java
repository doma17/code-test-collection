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
        
        long x = Long.parseLong(st.nextToken());    
        long y = Long.parseLong(st.nextToken());
        long result = (x > y ? getGcd(x, y) : getGcd(y, x));

        for (int i = 0; i < result; i++) {
            bw.write("1");
        }
        bw.write("\n");
        bw.flush();
    }

    private static long getGcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return getGcd(y, x % y);
    }
 }