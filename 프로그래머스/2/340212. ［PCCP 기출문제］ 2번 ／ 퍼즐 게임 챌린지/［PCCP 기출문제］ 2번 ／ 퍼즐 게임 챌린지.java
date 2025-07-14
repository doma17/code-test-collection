import java.util.*;

/** Parametric Search를 이용한 탐색 문제
 *  예외처리: 정답 level이 1인 경우는?
 *  소요시간: 20분
 */
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int mid = 0;
        
        while (left <= right) {
            mid = (left + right) / 2;
            
            if (canSolvePuzzleInLimit(diffs, times, limit, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean canSolvePuzzleInLimit(int[] diffs, int[] times, long limit, int level) {
        long solve_time = 0; // 총 문제 풀이 시간
        int time_prev = 0; // 이전 퍼즐 소요 시간
        
        for (int i = 0; i < diffs.length; i++) {
            int cur_diff = diffs[i];
            int cur_time = times[i];
            
            if (cur_diff <= level) {
                solve_time += cur_time;
            } else {
                int level_diff = cur_diff - level;
                solve_time += (cur_time + time_prev) * level_diff + cur_time;
            }
            time_prev = cur_time;
            
            if (solve_time > limit) {
                return false;
            }
        }
        return true;
    }
}