import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public int solution(int[] a) {

        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (minValue > a[i]) {
                minValue = a[i];
                minIndex = i;
            }
        }

        int answer = 0;
        int point = Integer.MAX_VALUE;
        for (int i = 0; i < minIndex; i++) {
            if (point >= a[i]) {
                point = a[i];
                answer += 1;
            }
        }
        point = Integer.MAX_VALUE;
        for (int i = a.length - 1; i > minIndex; i--) {
            if (point >= a[i]) {
                point = a[i];
                answer += 1;
            }
        }

        return ++answer;
    }
}