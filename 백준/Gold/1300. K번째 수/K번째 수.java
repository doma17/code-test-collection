import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 이진탐색
        int ans = 0;
        int start = 1;
        int end = k;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += Math.min(n, mid / i);
            }
            if (sum < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}