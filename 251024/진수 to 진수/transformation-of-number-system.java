import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        int a = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);

        int[] digits = new int[20];
        int cnt = 0;
        while (true) {
            if(n < a) {
                digits[cnt++] = n;
                break;
            }
        
            digits[cnt++] = n % a;
            n /= a;
        }

        for(int i = cnt - 1; i >= 0; i--)
            System.out.print(digits[i]);
    }
}
