class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        recursion(arr, 0, 0, arr.length, answer);
        return answer;
    }

    /**
     * 4분할로 나누어 압축이 가능한지 확인
     */
    public void recursion(int[][] arr, int x, int y, int size, int[] answer) {
        if (compress(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return;
        } else {
            recursion(arr, x, y, size/2, answer);
            recursion(arr, x, y + size/2, size/2, answer);
            recursion(arr, x + size/2, y, size/2, answer);
            recursion(arr, x + size/2, y + size/2, size/2, answer);
        }
    }

    /**
     * 정해진 사각형 내부의 값이 모두 같은지 확인 즉, 압축이 가능한지 확인
     */
    public boolean compress(int[][] arr, int x, int y, int length, int val) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}