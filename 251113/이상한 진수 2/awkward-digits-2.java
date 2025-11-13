import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < a.length(); i++) {
            if (a.charAt(i) == '0') {
                sb.append("1");
                break;
            }
            sb.append("1");
        }
        if (i + 1 <= a.length()) {
            sb.append(a.substring(i + 1, a.length()));
        } else {
            sb.setLength(sb.length() - 1);
            sb.append(0);
        }
            
        String originA = sb.toString();
        int answer = Integer.parseInt(originA, 2);
        System.out.println(answer);
    }
}