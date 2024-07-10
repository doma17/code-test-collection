import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

        int size = 0;
        for (String operation : operations) {
            String[] contents = operation.split(" ");

            if (contents[0].equals("I")) {
                size++;
                pq1.add(Integer.parseInt(contents[1]));
                pq2.add(Integer.parseInt(contents[1]));
            } else if (contents[0].equals("D")) { // 큐에서 최대값을 삭제합니다
                if (size == 0)
                    continue;
                if (contents[1].equals("1")) {
                    size--;
                    pq2.poll();
                }
                else { // "-1" 큐에서 최솟값을 삭제합니다
                    size--;
                    pq1.poll();
                }
            }

            if (size == 0) {
                pq1.clear();
                pq2.clear();
            }
        }

        if (size != 0) {
            answer[0] = pq2.peek();
            answer[1] = pq1.peek();
        }
        return answer;
    }
}