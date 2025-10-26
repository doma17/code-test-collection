class Solution {
    
    int N;
    int[] Info;
    int maxDiff = -1;
    int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        N = n;
        Info = info;
        
        int[] myInfo = new int[info.length];
        dfs(myInfo, N, 0);
        
        return answer;
    }
    
    public void dfs(int[] myInfo, int leftArrow, int index) {
        if (index > 10) {
            myInfo[10] += leftArrow;
            scoreUpdate(myInfo);
            myInfo[10] -= leftArrow;
            return;
        }
        
        // 백트레킹
        int needed = Info[index] + 1;
        if (leftArrow >= needed) {
            myInfo[index] = needed;
            dfs(myInfo, leftArrow - needed, index + 1);
            myInfo[index] = 0;
        }
        
        myInfo[index] = 0;
        dfs(myInfo, leftArrow, index + 1);
    }
    
    private void scoreUpdate(int[] myInfo) {
        int myScore = 0;
        int pitchScore = 0;
        
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            if (myInfo[i] == 0 && Info[i] == 0) continue;
            if (myInfo[i] > Info[i]) myScore += score;
            if (myInfo[i] <= Info[i]) pitchScore += score;
        }
        
        int diff = myScore - pitchScore;
        
        if (diff <= 0) return;
        if (diff > maxDiff) {
            maxDiff = diff;
            answer = myInfo.clone();
        } else if (diff == maxDiff) {
            if (isPriority(myInfo, answer)) {
                answer = myInfo.clone();
            }
        }
    }
    
    private boolean isPriority(int[] myInfo, int[] curAnswer) {
        for (int i = 10; i >= 0; i--) {
            if (myInfo[i] > curAnswer[i]) {
                return true;
            } else if (myInfo[i] < curAnswer[i]) {
                return false;
            }
        }
        return false;
    }
}