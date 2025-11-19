import java.util.*;
import java.io.*;

public class Main {

    static String[] arr;
    static int n;
    static int m;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (arr[r].charAt(c) != 'L') continue;
                answer += getCountOfLee(r, c);
            }
        }
        System.out.println(answer);
    }

    static int getCountOfLee(int r, int c) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nr1 = r + dr[i];
            int nc1 = c + dc[i];
            
            int nr2 = r + 2 * dr[i];
            int nc2 = c + 2 * dc[i];

            if (nr2 < 0 || nr2 >= n || nc2 < 0 || nc2 >= m) continue;
            if (arr[nr1].charAt(nc1) == 'E' && arr[nr2].charAt(nc2) == 'E') {
                count++;
            }
        }       
        return count;
    }
}