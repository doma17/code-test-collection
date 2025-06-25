import java.util.*;
import java.math.*;

class Solution {
    public String solution(String s) {
        String[] tmp = s.split(" ");
        int min = Integer.parseInt(tmp[0]);
        int max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
            min = Math.min(min, Integer.parseInt(tmp[i]));
            max = Math.max(max, Integer.parseInt(tmp[i]));
        }
        return min + " " + max;
    }
}