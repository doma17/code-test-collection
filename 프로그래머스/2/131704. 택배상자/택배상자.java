import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        Stack<Integer> stack = new Stack<>();
        int boxNum = 1;
        
        for (int i = 0; i < n; i++) {
            int target = order[i];
            
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
                continue;
            }
            
            if (target >= boxNum) {
                while (target > boxNum) {
                    stack.push(boxNum);
                    boxNum++;
                }
                boxNum++;
                answer++;
                continue;
            }
            break;
        }
        
        
        
        return answer;
    }
}