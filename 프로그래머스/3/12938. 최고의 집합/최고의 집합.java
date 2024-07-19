import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        // 최고의 집합이 존재하지 않는 경우
        if (n > s)
            return new int[]{-1};

        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        // 남은 집합의 값
        int left = s - ((s / n) * n);

        // 남은 집합의 값을 뒤에서 부터 1씩 할당
        int i = n - 1;
        while (left != 0) {
            answer[i--] += 1;
            left--;
            if (i == 0) i = n - 1;
        }

        return answer;
    }
}