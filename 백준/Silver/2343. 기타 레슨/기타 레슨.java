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
    static int m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, A[i]);
            right += A[i];
        }

        int mid = right;
        while (left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + A[i] > mid) { // 다음 블루레이 디스크 사용
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }
            if (sum != 0) { // 마지막 디스크 사용시 cnt 증가
                cnt++;
            }
            
            if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}