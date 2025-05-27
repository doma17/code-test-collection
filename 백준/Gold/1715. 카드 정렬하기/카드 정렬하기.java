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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (pq.isEmpty()) {
                break;
            }
            int y = pq.poll();
            cnt += x + y;
            pq.add(x + y);
        }
        System.out.println(cnt);
    }
}