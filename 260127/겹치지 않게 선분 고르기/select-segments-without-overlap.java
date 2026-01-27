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

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int last = list.get(i).r;

            for (int j = i + 1; j < n; j++) {
                Line o = list.get(j);
                if (last < o.l) {
                    last = o.r;
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}