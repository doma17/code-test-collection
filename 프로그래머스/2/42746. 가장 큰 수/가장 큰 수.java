import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberStr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberStr, (a, b) -> {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            });

        for (String str : numberStr) {
            answer += str;
        }
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}