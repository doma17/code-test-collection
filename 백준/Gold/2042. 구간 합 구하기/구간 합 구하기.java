import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, k;

    static long[] tree;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        // 트리 높이 측정
        int treeHeight = 0;
        int tmp = n;
        while (tmp != 0) {
            tmp /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];
        for (int i = leafStartIndex + 1; i <= leafStartIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        makeTree(treeSize - 1);
        
        for (int i = 0; i < m + k; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            if (a == 1) {
                // b번째 수를 c로 바꿈
                changeValue(b + leafStartIndex, c);
            } else {
                // b번째 수부터 c까지의 합
                System.out.println(getSum(b + leafStartIndex, (int) c + leafStartIndex));
            }
        }
    }

    static long getSum(int start, int end) {
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }

    static void changeValue(int index, long value) {
        // 기존 구간합 제거 및 변경
        long change = value - tree[index] ;
        tree[index] = value;
        while (index > 0) {
            tree[index / 2] += change;
            index /= 2;
        }
    }

    // 트리 형태로 구간합 표현 
    static void makeTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
