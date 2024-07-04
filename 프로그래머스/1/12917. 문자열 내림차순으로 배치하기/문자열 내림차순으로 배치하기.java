import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());

        for (String a : str)
            answer.append(a);

        return answer.toString();
    }
}