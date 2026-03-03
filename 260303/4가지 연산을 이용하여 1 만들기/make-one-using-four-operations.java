import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bfs(n);
    }

    private static void bfs(int start) {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(start, 0));
        boolean[] visited = new boolean[start + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            Num n = q.poll();
            if (n.num == 1) {
                System.out.println(n.count);
                break;
            }

            // 1. -1
            if (1 < n.num && !visited[n.num - 1]) {
                visited[n.num - 1] = true;
                q.add(new Num(n.num - 1, n.count + 1));
            }
            // 2. +1
            if (start < n.num && !visited[n.num + 1]) {
                visited[n.num + 1] = true;
                q.add(new Num(n.num + 1, n.count + 1));
            }
            // 3. /2
            if (n.num % 2 == 0 && !visited[n.num / 2]) {
                visited[n.num / 2] = true;
                q.add(new Num(n.num / 2, n.count + 1));
            }
            // 4. /3
            if (n.num % 3 == 0 && !visited[n.num / 3]) {
                visited[n.num / 3] = true;
                q.add(new Num(n.num / 3, n.count + 1));
            }
        }
    }

    static class Num {

        int num;
        int count;

        public Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}