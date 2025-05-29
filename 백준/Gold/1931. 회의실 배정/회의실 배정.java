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
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        // 가장 종료 시간이 이른순으로 정렬
        Arrays.sort(A, (x, y) -> {
            if (x[1] == y[1]) { // 끝나는 시간이 같으면 시작하는 시간 기준으로 정렬
                return x[0] - y[0];
            }
            return x[1] - y[1];
        });

        int ans = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (A[i][0] >= endTime) { // 현재 인덱스의 시작하는 시간이 이전 종료시간 이후 -> 겹치지 않음
                ans++;
                endTime = A[i][1];
            }
        }
        System.out.println(ans);
    }
}