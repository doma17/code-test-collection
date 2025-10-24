import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();

            pq.add(new Node(i + 1, height, weight));
        }
        
        while (!pq.isEmpty()) {
            pq.poll().printContext();
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int height;
        int weight;

        public Node(int index, int height, int weight) {
            this.index = index;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.height != o.height) return this.height - o.height;
            return o.weight - this.weight;
        }

        public void printContext() {
            System.out.println(height + " " + weight + " " + index);
        }
    }
}