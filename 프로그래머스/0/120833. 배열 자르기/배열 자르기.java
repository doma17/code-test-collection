class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int x = num2 - num1 + 1;
        int[] answer = new int[x];
        for (int i = 0; i < x; i++) {
            answer[i] = numbers[i + num1];
        }
        return answer;
    }
}