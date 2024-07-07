import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        if (arr.length == 1) return answer;
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    public int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    public int gcd(int x, int y) {
        int z = x % y;
        if (z == 0) return y;
        return gcd(y, z);
    }
}