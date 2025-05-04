import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long M = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] s = new long[N];
        for (int i = 0; i < s.length; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(s);

        int start = 0;
        int end = N - 1;
        int answer = 0;

        while (start < end) {
            if (s[start] + s[end] == M) {
                end--;
                start++;
                answer++;
            } else if (s[start] + s[end] > M) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer);
    }
}