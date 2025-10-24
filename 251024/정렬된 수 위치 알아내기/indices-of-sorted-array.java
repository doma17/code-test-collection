import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            list.add(new Node(i, arr[i]));
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            Node o = list.get(i);
            arr[o.originIndex] = i + 1;
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    static class Node implements Comparable<Node> {

        int originIndex;
        int value;

        public Node(int originIndex, int value) {
            this.originIndex = originIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value != o.value) return this.value - o.value;
            return this.originIndex - o.originIndex;
        }
    }
}