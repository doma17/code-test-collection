import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sumArr = new long[N + 1]; 
        long[] remainArr = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < sumArr.length; ++i)
        {
            sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i - 1];
            int remainder = (int) (sumArr[i] % M);
            if(remainder == 0) ++count;
            ++remainArr[remainder];
        }

        for(int i = 0; i < M; ++i)
        {
            if(remainArr[i] > 1) count += (remainArr[i] * (remainArr[i] - 1) / 2);
        }

        System.out.println(count);
    }
}