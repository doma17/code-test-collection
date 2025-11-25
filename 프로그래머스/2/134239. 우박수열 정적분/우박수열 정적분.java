import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int[] arr = createCollatzArray(k);
        int n = arr.length;

        double[] sum = new double[n];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + (arr[i - 1] + arr[i]) / 2.0;
        }

        // 구간합
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = (n - 1) + ranges[i][1];

            if (x1 > x2) {
                answer[i] = -1.0;
            } else {
                answer[i] = sum[x2] - sum[x1];
            }
        }
        return answer;
    }
    
    private int[] createCollatzArray(int k) {
        ArrayList<Integer> collatzList = new ArrayList<>();
        collatzList.add(k);
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            collatzList.add(k);
        }
        return collatzList.stream().mapToInt(Integer::intValue).toArray();
    }
}