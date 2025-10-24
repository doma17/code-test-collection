import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            // Please write your code here.

            list.add(new Node(name, height, weight));
        }

        Collections.sort(list, (a, b) -> {
            return a.height != b.height ? a.height - b.height : Double.compare(b.weight, a.weight);
        });
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
            System.out.println(name + " " + height + " " + (int) weight);
        }
    }
}