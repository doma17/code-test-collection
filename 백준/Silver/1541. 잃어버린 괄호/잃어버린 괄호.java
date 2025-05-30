import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int ans = 0;

        String[] arr = br.readLine().split("-");
        for (int i = 0; i < arr.length; i++) {
            String[] tmp = arr[i].split("\\+");
            int sum = 0;
            for (int j = 0; j < tmp.length; j++) {
                sum += Integer.parseInt(tmp[j]);
            }
            if (i == 0) {
                ans += sum;
            } else {
                ans -= sum;
            }
        }

        System.out.println(ans);
    }
}