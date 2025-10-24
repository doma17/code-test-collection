import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        String[] names = new String[n];
        int[] heights = new int[n];
        double[] weights = new double[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            heights[i] = sc.nextInt();
            weights[i] = sc.nextDouble();
        }

        // 이름 순 출력
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(names[i], heights[i], weights[i]));
        }
        Collections.sort(list, (a, b) -> a.name.compareTo(b.name));

        System.out.println("name");        
        for (Node x : list) {
            x.printContext();
        }
        System.out.println();
        
        // 키가 큰 순 출력
        System.out.println("height");
        Collections.sort(list, (a, b) -> b.height - a.height);
        for (Node x : list) {
            x.printContext();
        }
    }

    static class Node {
        String name;
        int height;
        double weight;

        public Node(String name, int height, double weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        public void printContext() {
            System.out.println(name + " " + height + " " + weight);
        }
    }
}