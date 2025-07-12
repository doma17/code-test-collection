import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        ArrayList<Long> list = new ArrayList<>();
        for (String ban : bans) {
            list.add(convertToLong(ban));
        }
        Collections.sort(list);

        long target = n;
        for (Long ban : list) {
            if (target >= ban) ++target;
            else break;
        }
        return convertToString(target);
    }

    private String convertToString(long number) {
        StringBuilder sb = new StringBuilder();
        while(number-- > 0) {
            int c = 'a' + (int) (number % 26);
            sb.append((char) c);
            number /= 26;
        }
        return sb.reverse().toString();
    }

    private Long convertToLong(String input) {
        long result = 0L;
        char[] arr = input.toCharArray();
        for (char x : arr) {
            result = result * 26 + (x - 'a' + 1);
        }
        return result;
    }
}