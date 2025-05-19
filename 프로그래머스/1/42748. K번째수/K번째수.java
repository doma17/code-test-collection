import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;

        for (int[] command : commands) {
            int i = command[0] - 1;
            int j = command[1];
            int k = command[2];

            ArrayList<Integer> list = new ArrayList<>();
            for (;i < j; i++) {
                list.add(array[i]);
            }
            list.sort((x, y) -> x - y);
            answer[index++] = list.get(k - 1);
        }
        return answer;
    }
}