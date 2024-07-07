class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        // t * m 개의 숫자를 구해놓는다.
        while (sb.length() < t * m) {
            // n진법으로 변환하여 sb에 추가
            sb.append(Integer.toString(num++, n));
        }

        // 튜브의 순서에 맞는 숫자를 answer에 추가
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt(m * i + p - 1));
        }

        return answer.toString().toUpperCase();
    }
}