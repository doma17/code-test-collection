import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());        
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");            
            pq.add(new Node(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }

        while (!pq.isEmpty()) {
            pq.poll().printContext();
        }
        br.close();
    }

    static class Node implements Comparable<Node> {
        String name;
        int height;
        int weight;

        public Node(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.height - o.height;
        }

        public void printContext() {
            System.out.println(name + " " + height + " " + weight);
        }
    }
}