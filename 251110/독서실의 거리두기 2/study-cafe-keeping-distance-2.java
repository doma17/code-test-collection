import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        
        char[] arr = s.toCharArray();
        int maxLength = 0;
        int minLength = 10001;
        int first = -1;
        int last = -1;
        
        int curLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '1') {
                if (first == -1) {
                    first = i;
                } else {
                    maxLength = Math.max(maxLength, curLength);
                    minLength = Math.min(minLength, curLength);
                }
                curLength = 0;
                last = i;
            }
            curLength++;
        }
        
        int maxDist = first;

        int lastLength = (arr.length - 1) - last;
        maxDist = Math.max(maxDist, lastLength);
        int midLength = (maxLength + 1) / 2;
        maxDist = Math.max(maxDist, midLength);

        if (maxDist < minLength) System.out.println(maxDist);
        else System.out.println(minLength);
    }
}