import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] tangerineCount = new int[10_000_001];
        
        for (int i = 0; i < tangerine.length; i++) {
            tangerineCount[tangerine[i]]++;
        }
        for (int i = 0; i < tangerineCount.length; i++) {
            if (tangerineCount[i] > 0) {
                pq.offer(tangerineCount[i]);
            }
        }
        
        while (k > 0) {
            int box = pq.poll();
            k -= box;
            answer++;
        }
        
        return answer;
    }
}