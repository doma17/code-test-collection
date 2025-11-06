class Solution {
    public int[] solution(int n, int[] info) {
        N = n;
        pitchInfo = info;
        
        int[] lion = new int[info.length];
        dfs(lion, n, 0);
    
        return answer;
    }
    
    int N;
    int[] pitchInfo;
    int[] answer = {-1};
    int maxDiff = -1;
    
    void dfs(int[] lionInfo, int leftArrow, int index) {
        if (index > 10) {
            lionInfo[10] += leftArrow;
            updateAnswer(lionInfo);
            lionInfo[10] -= leftArrow;
            return;
        }
        
        int expect = pitchInfo[index] + 1;
        if (leftArrow >= expect) {
            lionInfo[index] = expect;
            dfs(lionInfo, leftArrow - expect, index + 1);
            lionInfo[index] = 0;
        }
        
        dfs(lionInfo, leftArrow, index + 1);
    }
    
    void updateAnswer(int[] lionInfo) {
        int lionScore = 0;
        int pitchScore = 0;
        
        // 점수계산
        for (int i = 0; i <= 10; i++) {
            if (lionInfo[i] == 0 && pitchInfo[i] == 0) continue;
            
            if (lionInfo[i] > pitchInfo[i]) {
                lionScore += (10 - i);
            } else {
                pitchScore += (10 - i);
            }
        }
        
        // 점수비교
        if (pitchScore >= lionScore) return;
        int diff = lionScore - pitchScore;
        
        // 가장 낮은 점수를 더 많이 맞힌 경우..
        if (maxDiff < diff) {
            maxDiff = diff;
            answer = lionInfo.clone();
        } else if (maxDiff == diff) {
            if (isPrior(lionInfo)) {
                answer = lionInfo.clone();
            }
        }
    }
    
    boolean isPrior(int[] lionInfo) {
        for (int i = 10; i >= 0; i--) {
            if (lionInfo[i] > answer[i]) return true;
            else if (lionInfo[i] < answer[i]) return false;
        }
        return false;
    }
}