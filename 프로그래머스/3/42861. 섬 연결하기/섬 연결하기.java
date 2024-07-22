import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] link = new int[100];
    public int[] size = new int[100];

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            link[i] = i;
            size[i] = 1;
        }

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            if (!same(a, b)) {
                unite(a, b);
                answer += c;
            }
        }

        return answer;
    }

    public int find(int x) {
        while (x != link[x]) x = link[x];
        return x;
    }

    public boolean same(int a, int b) {
        return find(a) == find(b);
    }

    public void unite(int a, int b) {
        a = find(a);
        b = find(b);

        if (size[a] < size[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        size[a] += size[b];
        link[b] = a;
    }
}