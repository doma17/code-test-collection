import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        while (true) {
            boolean exploded = false;
            ArrayList<Integer> nextList = new ArrayList<>();
            int idx = 0;

            while (idx < list.size()) {
                int end = idx;
                while (end < list.size() && list.get(idx).equals(list.get(end))) {
                    end++;
                }

                int count = end - idx;
                if (count >= m) {
                    exploded = true;
                } else {
                    for (int i = 0; i < count; i++) {
                        nextList.add(list.get(idx));
                    }
                }
                idx = end;
            }

            list = nextList;
            if (!exploded) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}