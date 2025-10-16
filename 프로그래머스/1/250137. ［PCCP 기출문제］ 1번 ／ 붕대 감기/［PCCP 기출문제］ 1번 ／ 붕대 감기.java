class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int curHealth = health;
        int cnt = 0;
        int attackIdx = 0;
        int successIdx = 0;
        while (curHealth > 0) {
            if (attackIdx == attacks.length) return curHealth;
            int[] attack = attacks[attackIdx];
            
            if (cnt == attack[0]) { // 공격에 맞음
                curHealth -= attack[1];
                successIdx = 0;
                attackIdx++;
                
                System.out.println(cnt + " " + curHealth + " " + successIdx + " ");
            } else { // 붕대 감기
                successIdx++;
                if (successIdx == bandage[0]) {
                    curHealth += bandage[2];
                    successIdx = 0;
                }
                curHealth += bandage[1];
                
                // 최대 체력 제한
                if (curHealth > health) curHealth = health;
                System.out.println(cnt + " " + curHealth + " " + successIdx + " ");
            }
            cnt++;
        }
        return -1;
    }
}