import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = sum - arr[i];
            for (int j = i + 1; j < n; j++) {
                diff = Math.min(diff, Math.abs(s - (tmp - arr[j])));
            }
        }
        System.out.println(diff);
    }
}