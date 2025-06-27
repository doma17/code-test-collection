import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int rootNode = -1;
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(tmp[i]);
            if (p == -1) {
                rootNode = i;
            } else {
                list[p].add(i);
            }
        }

        int deletedNode = Integer.parseInt(br.readLine());
        // 루트가 삭제 대상이면 리프 개수는 0
        if (deletedNode == rootNode) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (list[i].contains(deletedNode)) {
                list[i].remove(Integer.valueOf(deletedNode));
            }
        }

        // BFS 로 리프 개수 세기
        int leafCount = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(rootNode);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (list[cur].isEmpty()) {
                leafCount++;
            } else {
                for (int next : list[cur]) {
                    q.add(next);
                }
            }
        }

        System.out.println(leafCount);
    }
}
