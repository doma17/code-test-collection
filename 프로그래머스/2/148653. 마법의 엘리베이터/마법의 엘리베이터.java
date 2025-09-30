class Solution {
    public int solution(int floor) {
        int answer = 0;
        
        while (floor > 0) {
            int x = floor % 10;
            floor /= 10;
            
            if (x < 5) {
                answer += x;
            } else if (x > 5) {
                answer += (10 - x);
                floor++;
            } else if (floor % 10 >= 5) {
                answer += 5;
                floor++;
            } else {
                answer += 5;
            }
        }
        
        return answer;
    }
}