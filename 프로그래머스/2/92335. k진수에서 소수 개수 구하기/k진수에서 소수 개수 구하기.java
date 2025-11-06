import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        String num = Long.toString(n, k);
        
        String[] tmp = num.split("0+");
        HashMap<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        for (var x : tmp) {
            if (x.isEmpty()) continue;
            long xL = Long.parseLong(x);
            if (map.get(xL) != null || isPrime(xL)) {
                map.put(xL, 1);
                cnt++;
            }
        }
        
        for (var x : map.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
        return cnt;
    }
    
    boolean isPrime(long num) {
        if (num == 1) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}