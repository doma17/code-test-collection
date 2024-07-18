import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Comparator.reverseOrder());
        for (int a : A) {
            pqA.add(a);
        }
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Comparator.reverseOrder());
        for (int b : B) {
            pqB.add(b);
        }

        int answer = 0;
        while (!pqA.isEmpty()) {
            int a = pqA.poll();
            int b = pqB.poll();

            if (a >= b) {
                pqB.add(b);
            } else {
                answer++;
            }
        }

        return answer;
    }
}