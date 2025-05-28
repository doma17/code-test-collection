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
        int sum = 0;
        int zero = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return y - x;
        });
        PriorityQueue<Integer> nq = new PriorityQueue<>((x, y) -> {
            return x - y;
        });
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 1) {
                sum += 1;
            } else if (input == 0) {
                zero += 1;
            } else if (input > 0) {
                pq.add(input);
            } else if (input < 0) {
                nq.add(input);
            }
        }

        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (pq.isEmpty()) {
                sum += x;
                break;
            }
            int y = pq.poll();
            sum += x * y;
        }
        while (!nq.isEmpty()) {
            int x = nq.poll();
            if (nq.isEmpty()) {
                if (zero == 0) {
                    sum += x;
                }
                break;
            }
            int y = nq.poll();
            sum += x * y;
        }
        System.out.println(sum);
    }
}