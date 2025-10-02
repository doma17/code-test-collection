import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emotions) {        
        int plus = 0; // 플러스 가입자 수
        int sale = 0; // 판매액
        int[] saleRate = new int[emotions.length]; // 할인율 배열
        
        for (int i = 0; i < (int) Math.pow(4, emotions.length); i++) {
            // 각 이모티콘 별 할인율 경우의 수 전체 탐색
            for (int j = 0; j < saleRate.length; j++) {
                saleRate[j] = 10 * (1 + (i / (int) Math.pow(4, j)) % 4);
            }
            int userPlus = 0;
            int userSaleSum = 0;
            
            // 해당 할인율 경우의 수에 대해서 탐색
            for (int j = 0; j < users.length; j++) {
                int userSale = 0;
                int userSaleRate = users[j][0];
                for (int k = 0; k < saleRate.length; k++) {
                    // 할인율 적용
                    if (saleRate[k] >= userSaleRate) {
                        userSale += (emotions[k] * (100 - saleRate[k])) / 100;
                    }
                }
                // 이모티콘 플러스 가입 기준
                if (userSale >= users[j][1]) {
                    userPlus++;
                } else {
                    userSaleSum += userSale;
                }
            }
            
            // 목표 - 가입자 수가 같으면 판매액 최대
            if (userPlus == plus) {
                sale = Math.max(sale, userSaleSum);
            } else if (userPlus >= plus) {
                plus = userPlus;
                sale = userSaleSum;
            }
        }
        
        return new int[] {plus, sale};
    }
}