import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            int distance = Math.abs(points[i][0]) + Math.abs(points[i][1]);
            pq.add(new Node(i + 1, distance));
        }
        
        while (!pq.isEmpty()) {
            pq.poll().printNum();
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int distance; 

        public Node(int num, int distance) {
            this.distance = distance;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance != o.distance) return this.distance - o.distance;
            return this.num - o.num;
        }

        public void printNum() {
            System.out.println(num);
        }
    }
}