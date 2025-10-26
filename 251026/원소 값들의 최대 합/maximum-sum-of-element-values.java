import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] arr = new int[n + 1];

        tmp = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(tmp[i - 1]);
        }

        int maxSum = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int curIndex = i;

            for (int j = 0; j < m; j++) {
                int value = arr[curIndex];
                sum += value;

                int nextIndex = value;
                if (nextIndex < 1 || nextIndex > n) break;

                curIndex = nextIndex;
            }

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println(maxSum);
    }
}