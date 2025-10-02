import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long limitDistance = (long) Math.pow(d, 2);
        
        for (int i = 0; i <= d; i += k) {
            long x = (long) Math.pow(i, 2);
            long left = (long) Math.sqrt(limitDistance - x);
            answer += left / k + 1;
        }
        
        return answer;
    }
}