import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            String tmp;
            if (a > b) tmp = b + " " + a;
            else tmp = a + " " + b;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        int maxCount = 0;
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            maxCount = Math.max(maxCount, x.getValue());
        }
        System.out.println(maxCount);
    }
}