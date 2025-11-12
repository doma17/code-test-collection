import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> oldMap = new HashMap<>();
        HashMap<Integer, Integer> youngMap = new HashMap<>();
        
        oldMap.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            youngMap.put(topping[i], youngMap.getOrDefault(topping[i], 0) + 1);
        }
        
        int cnt = 0;
        for (int i = 1; i < topping.length - 1; i++) {
            if (oldMap.size() == youngMap.size()) cnt++;
            
            int top = topping[i];
            int youngCount = youngMap.get(top);
            if (youngCount == 1) {
                youngMap.remove(top);
            } else {
                youngMap.put(top, youngCount - 1);
            }
            
            oldMap.put(top, oldMap.getOrDefault(top, 0) + 1);
        }
        return cnt;
    }
}