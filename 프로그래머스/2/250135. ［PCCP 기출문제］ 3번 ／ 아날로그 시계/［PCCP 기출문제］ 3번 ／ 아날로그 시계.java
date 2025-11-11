class Solution {
    
    // 시간 -> 초 변환
    private long convertSec(int h, int m, int s) {
        return h * 3600L + m * 60L + s;
    }

    // 초침/분침 겹칠 경우 : 비례한 각속도
    private long countSecondMinute(long t) {
        return (t * (60 - 1)) / 3600;
    }

    // 초침/시침 겹칠 경우 : 719는 비례한 각속도
    private long countSecondHour(long t) {
        return (t * (720 - 1)) / (3600 * 12);
    }

    // 셋 다 겹칠 경우는 정각만 해당
    private long countTriple(long t) {
        return t / (3600 * 12);
    }

    // 분침/시침 계산에서 이미 정각인 경우도 포함되기 때문에 누적합 빼기 처리
    private long countUpTo(long t) {
        return countSecondMinute(t) + countSecondHour(t) - countTriple(t);
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long start = convertSec(h1, m1, s1);
        long end = convertSec(h2, m2, s2);
        
        long ans = countUpTo(end) - countUpTo(start);
        // 정시에 시작하면 겹침
        if (start % 3600L == 0) ans += 1;
        return (int) ans;
    }
}
