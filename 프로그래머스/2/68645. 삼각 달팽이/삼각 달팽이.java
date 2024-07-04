class Solution {
        public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] matrix = new int[n][n];
        int x = -1, y = 0;
        int v = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0)
                    x++;
                else if (i % 3 == 1)
                    y++;
                else {
                    x--;
                    y--;
                }
                matrix[x][y] = v++;
            }
        }

        int index = 0;
        for (int[] m : matrix) {
            for (int i : m) {
                if (i == 0) break;
                answer[index++] = i;
            }
        }

        return answer;
    }
}