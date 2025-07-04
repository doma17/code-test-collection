import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;

    static long[] tree;
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        k = Integer.parseInt(tmp[2]);

        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int) Math.pow(2, height + 1) - 1;

        int leafNodeIndex = 1;
        while (leafNodeIndex < n) {
            leafNodeIndex <<= 1;
        }
        tree = new long[treeSize];
        Arrays.fill(tree, 1);

        for (int i = 0; i < n; i++) {
            tree[leafNodeIndex + i] = Long.parseLong(br.readLine());
        }
        makeTree(treeSize - 1);

        for (int i = 0; i < m + k; i++) {
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            long c = Long.parseLong(tmp[2]);

            if (a == 1) { // b번째 수를 c로 변경
                changeValue(leafNodeIndex + b - 1, c);
            } else if (a == 2) { // b부터 c까지 곱
                sb.append(getMultiply(leafNodeIndex + b - 1, (int) (leafNodeIndex + c - 1)) + "\n");
            } else {
                return;
            }
        }

        System.out.println(sb.toString());
    }

    static long getMultiply(int b, int c) {
        long partMultiply = 1;
        
        while (b <= c) {
            if (b % 2 == 1) {
                partMultiply = partMultiply * tree[b] % MOD;
                b++;
            }
            if (c % 2 == 0) {
                partMultiply = partMultiply * tree[c] % MOD;
                c--;
            }
            b /= 2;
            c /= 2;
        }
        return partMultiply;
    }

    static void changeValue(int index, long value) {
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    static void makeTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}
