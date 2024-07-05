class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 타일의 총개수
        int total = brown + yellow;

        for (int i = 3; i < total; i++) {
            // 가로 길이 가정
            int j = (total) / i;

            if (total % i != 0) // 나누어 떨어지지 않으면
                continue;
            if (j < 3) // 세로가 3보다 작으면
                continue;

            // 둘중 큰 값을 가로길이로 정한다.
            int col = Math.max(i, j);
            int row = Math.min(i, j);
            int mid = (col - 2) * (row - 2);

            // 노란색 타일의 개수와 같으면
            if (mid == yellow) {
                answer[0] = col;
                answer[1] = row;
                return answer;
            }
        }
        return answer;
    }
}