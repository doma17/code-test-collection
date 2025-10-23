import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] korean = new int[n];
        int[] english = new int[n];
        int[] math = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            korean[i] = sc.nextInt();
            english[i] = sc.nextInt();
            math[i] = sc.nextInt();
        }
        // Please write your code here.
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Node(names[i], korean[i], english[i], math[i]));
        }

        while(!pq.isEmpty()) {
            pq.poll().printContext();
        }
    }

    static class Node implements Comparable<Node> {
        
        String name;
        int korean;
        int english;
        int math;

        public Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Node o) {
            if (this.korean != o.korean) return o.korean - this.korean;
            if (this.english != o.english) return o.english - this.english;
            return o.math - this.math;
        }

        public void printContext() {
            System.out.println(name + " " + korean + " " + english + " " + math);
        }
    }
}