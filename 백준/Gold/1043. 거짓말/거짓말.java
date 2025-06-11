import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] parents;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        // 진실 아는 사람 저장
        tmp = br.readLine().split(" ");
        int truePerson = Integer.parseInt(tmp[0]);
        int[] truth = new int[truePerson];
        for (int i = 0; i < truePerson; i++) {
            truth[i] = Integer.parseInt(tmp[i + 1]);
        }

        // 각 파티의 데이터 저장
        list = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<>();
            tmp = br.readLine().split(" ");
            int size = Integer.parseInt(tmp[0]);
            for (int j = 0; j < size; j++) {
                list[i].add(Integer.parseInt(tmp[j + 1]));
            }
        }

        // Process
        for (int i = 0; i < m; i++) {
            int frist = list[i].get(0);
            for (int j = 1; j < list[i].size(); j++) {
                union(frist, list[i].get(j)); // 파티 구성원 끼리 조합을 이룸
            }
        }
        
        // 진실을 아는 사람의 부모와 파티 첫 노드의 부모를 비교
        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            int frist = list[i].get(0);
            for (int j = 0; j < truePerson; j++) {
                if (find(frist) == find(truth[j])) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                ans++;
            }
        }
        
        // Output
        System.out.println(ans);
    }

    static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);  // 경로 압축
        }
        return parents[x];
    }

    static void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX != pY) {
            parents[pY] = pX;
        }
    }
}