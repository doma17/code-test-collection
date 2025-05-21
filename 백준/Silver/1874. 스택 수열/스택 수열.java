import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Process
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        boolean result = true;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            while (cnt <= now) {
                stack.push(cnt);
                sb.append("+\n");
                cnt++; 
            }
            if (stack.isEmpty() || stack.peek() != now) {
                result = false;
                break;
            } else {
                stack.pop();
                sb.append("-\n");
            }
        }

        if (result) {
            System.out.print(sb.toString());
        } else {
            System.out.print("NO\n");
        }
    }
}