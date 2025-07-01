import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, k;

    static long[] tree;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 트리 높이 측정
        int treeHeight = 0;
        int tmp = n;
        while (tmp != 0) {
            tmp /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafStartIndex = treeSize / 2;
        tree = new long[treeSize];
        for (int i = leafStartIndex; i < leafStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        
        for (int i = 1; i < leafStartIndex; i++) {
            tree[i] = Long.MAX_VALUE;
        }

        for (int i = leafStartIndex; i < leafStartIndex + n; i++) {
            int index = i;

            while (index != 0) {
                if (tree[index / 2] > tree[index]) {
                    tree[index / 2] = tree[index];
                } else {
                    break;
                }
                index /= 2;
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            long result = getMin(1, 1, leafStartIndex, a, b);
            System.out.println(result);
        }
    }
    
    // 구간 최솟값 쿼리
    static long getMin(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        
        // 부분적으로 포함되는 경우
        int mid = (start + end) / 2;
        long leftMin = getMin(node * 2, start, mid, left, right);
        long rightMin = getMin(node * 2 + 1, mid + 1, end, left, right);
        
        return Math.min(leftMin, rightMin);
    }
}
