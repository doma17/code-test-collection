import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
    private boolean[] visited;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)
            matrix.add(new ArrayList<>());

        for (int[] e : edge) {
            int x = e[0];
            int y = e[1];
            matrix.get(x).add(y);
            matrix.get(y).add(x);
        }

        return bfs();
    }

    public int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int next : matrix.get(current)) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return size;
    }
}