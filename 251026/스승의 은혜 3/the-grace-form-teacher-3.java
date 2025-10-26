import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            int s = sc.nextInt();
            list.add(new Node(p, s));
        }

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            Node target = list.get(i);
            
            ArrayList<Integer> cost = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    cost.add(target.p / 2 + target.s);
                }
                else cost.add(list.get(j).total);
            }

            Collections.sort(cost);
            int budget = b;
            int cnt = 0;
            for (int c : cost) {
                if (c <= budget) {
                    budget -= c;
                    cnt++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, cnt);
        }
        System.out.println(maxCount);
    }

    static class Node {
        int p;
        int s;
        int total;

        public Node(int p, int s) {
            this.p = p;
            this.s = s;
            this.total = p + s;
        }
    }
}