import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for (var e : elements) set.add(e);
        
        int n = elements.length;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            // 부분 수열 구하기
            for (int j = 0; j < n; j++) {
                sum += elements[(i + j) % n];
                set.add(sum);
            }
        }

        return set.size();
    }
}