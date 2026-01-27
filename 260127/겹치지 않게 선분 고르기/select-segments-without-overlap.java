import java.util.*;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];

        ArrayList<Line> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Line(sc.nextInt(), sc.nextInt()));
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