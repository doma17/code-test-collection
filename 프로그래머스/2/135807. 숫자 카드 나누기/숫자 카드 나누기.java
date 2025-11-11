import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = 0;
        for (int a : arrayA) {
            gcdA = gcd(gcdA, a);
            if (gcdA == 1) break;
        }
        
        boolean aIsPossible = true;
        for (int b : arrayB) {
            if (b % gcdA == 0) {
                aIsPossible = false;
                break;
            }
        }
        if (aIsPossible) answer = Math.max(answer, gcdA);
        
        int gcdB = 0;
        for (int b : arrayB) {
            gcdB = gcd(gcdB, b);
            if (gcdB == 1) break;
        }
        
        boolean bIsPossible = true;
        for (int a : arrayA) {
            if (a % gcdB == 0) {
                bIsPossible = false;
                break;
            }
        }
        if (bIsPossible) answer = Math.max(answer, gcdB);
        
        return answer;
    }
    
    int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}