import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // Init
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐로 절대값이 가장 작은 오름차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a == b) {
                return o1 > o2 ? 1 : -1;
            } else {
                return a > b ? 1 : -1;
            }
        }); 

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) { // 가장 작은 수를 출력
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }
            } else { 
                pq.add(v);
            }
        }

        System.out.println(sb.toString());
    }
}