import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 선물 지수 초기화
        HashMap<String, Integer> giftFactor = new HashMap<>();
        for (var name : friends) {
            giftFactor.put(name, 0);
        }
        
        // 'A -> B' 형태로 얼마나 선물을 보냈는지 저장
        HashMap<String, Integer> giftRecord = new HashMap<>();
        for (var gift : gifts) {
            giftRecord.put(gift, giftRecord.getOrDefault(gift, 0) + 1);
            
            // 'A -> B' 선물 지수 저장
            String[] tmp = gift.split(" ");
            giftFactor.put(tmp[0], giftFactor.getOrDefault(tmp[0], 0) + 1);
            giftFactor.put(tmp[1], giftFactor.getOrDefault(tmp[1], 0) - 1);
        }
        
        int[] nextGifts = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            String a = friends[i];
            int aGiftFactor = giftFactor.get(a);
            
            for (int j = i + 1; j < friends.length; j++) {
                // if (i == j) continue;
                
                String b = friends[j];
                int bGiftFactor = giftFactor.get(b);
                int a2b = giftRecord.getOrDefault(a + " " + b, 0);
                int b2a = giftRecord.getOrDefault(b + " " + a, 0);
                
                // 조건 1
                if (a2b != 0 || b2a != 0) {
                    if (a2b > b2a) {
                        nextGifts[i]++;
                    } else if (a2b < b2a) {
                        nextGifts[j]++;
                    }
                }
                // 조건 2
                if ((a2b == 0 && b2a == 0) || a2b == b2a) {
                    if (aGiftFactor != bGiftFactor) {
                        if (aGiftFactor > bGiftFactor) {
                            nextGifts[i]++;
                        } else if (aGiftFactor < bGiftFactor) {
                            nextGifts[j]++;
                        }
                    }
                }
            }
        }
        
        Arrays.sort(nextGifts);
        return nextGifts[friends.length - 1];
    }
}