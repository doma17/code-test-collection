import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        for (var s : s1) {
            set.add(s);
        }
        
        for (var s : s2) {
            if (set.contains(s)) answer++;
        }
        
        return answer;
    }
}