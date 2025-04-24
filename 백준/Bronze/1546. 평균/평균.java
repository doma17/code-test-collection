import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double sum = 0;
        double[] arr = new double[n];
        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            maxValue = Math.max(arr[i], maxValue);
        }

        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }

        System.out.println(sum / n / maxValue * 100);
    }
}
