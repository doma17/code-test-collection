import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int e : enemy) {
            if (k > 0) {
                pq.add(e);
                k--;
            } else {
                int x = pq.poll();
                if (e > x) {
                    pq.add(e);
                    n -= x;
                } else {
                    pq.add(x);
                    n -= e;
                }
            }
            if (n < 0) break;
            answer++;
        }
        
        return answer;
    }
}