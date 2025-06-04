import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());    
            int y = Integer.parseInt(st.nextToken());
            int result = x * y / (x > y ? getGcd(x, y) : getGcd(y, x));
            System.out.println(result);
        }      
    }
    
    // 최대 공약수 (두 수의 곱 / gcd -> lcm)
    private static int getGcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return getGcd(y, x % y);
    }
 }