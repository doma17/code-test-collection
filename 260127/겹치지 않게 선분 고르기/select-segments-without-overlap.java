import java.util.*;
import java.io.*;

public class Main {

    static class Line implements Comparable<Line> {
        int l, r;

        public Line(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public int compareTo(Line o) {
            if (this.r != o.r) return this.r - o.r;
            return this.l - o.l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] segments = new int[n][2];

        ArrayList<Line> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int count = 0;
        int lastEnd = -1;
        for (int i = 0; i < n; i++) {
            Line o = list.get(i);
            if (lastEnd < o.l) {
                lastEnd = o.r;
                count++;
            }
        }
        System.out.println(count);
    }
}