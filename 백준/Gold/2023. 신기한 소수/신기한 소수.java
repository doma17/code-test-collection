import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // Variable
    static int n;

    public static void main(String[] args) throws IOException {
        // Init
        n = Integer.parseInt(br.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int start, int digit) {
        if (digit == n) {
            if (isPrime(start)) {
                System.out.println(start);
            }
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            if (isPrime(start * 10 + i)) {
                DFS(start * 10 + i, digit + 1);
            }   
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}