import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // 오일러의 피 활용 문제 
        // (1 ~ N)까지 범위에서 N과 서로서인 자연수의 개수
        // 서로소인 (최대 공약수가 1)인 수를 찾는 법
        long n = Long.parseLong(br.readLine());
        long cnt = n;
        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                cnt -= cnt / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            cnt -= cnt / n;
        }
        System.out.println(cnt);
    }
 }