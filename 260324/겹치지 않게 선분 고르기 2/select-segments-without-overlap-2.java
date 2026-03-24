import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        ArrayList<Line> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            list.add(new Line(segments[i][0], segments[i][1]));
        }
        
        Collections.sort(list);

        int count = 1;
        Line first = list.get(0);
        int last = first.x2;
        for (int i = 1; i < n; i++) {
            Line line = list.get(i);
            if (line.x1 <= last) continue;
            last = line.x2;
            count++;
        }
        System.out.println(count);
    }

    static class Line implements Comparable<Line> {
        int x1, x2;

        public Line(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        public int compareTo(Line o) {
            if (this.x2 != o.x2) return this.x2 - o.x2;
            return this.x1 - o.x1;
        }
    }
}
