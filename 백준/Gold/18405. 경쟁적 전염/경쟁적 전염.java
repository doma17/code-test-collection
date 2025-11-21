import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        tmp = br.readLine().split(" ");
        int s = Integer.parseInt(tmp[0]);
        int x = Integer.parseInt(tmp[1]) - 1;
        int y = Integer.parseInt(tmp[2]) - 1;

        int minTime = Integer.MAX_VALUE;
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    int distance = Math.abs(x - i) + Math.abs(y - j);

                    if (distance <= s) {
                        if (distance < minTime) {
                            minTime = distance;
                            num = map[i][j];
                        } else if (distance == minTime) {
                            num = Math.min(num, map[i][j]);
                        }
                    }
                }
            }
        }

        System.out.println(num);
    }
}