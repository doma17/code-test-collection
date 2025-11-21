class Solution {
    
    int TARGET_NUM;
    int answer = 0;
    int[] nums;
    
    public int solution(int[] numbers, int target) {
        TARGET_NUM = target;
        nums = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int sum, int curIndex) {
        if (curIndex == nums.length) {
            if (TARGET_NUM == sum) {
                answer++;
            }
            return;
        }
        dfs(sum + nums[curIndex], curIndex + 1);
        dfs(sum - nums[curIndex], curIndex + 1);
    }
}