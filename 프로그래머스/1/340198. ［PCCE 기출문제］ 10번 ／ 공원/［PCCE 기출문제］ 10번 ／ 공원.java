import java.util.*;

class Solution {
    
    private String[][] parkMap;
    private int xLength;
    private int yLength;
    
    public int solution(int[] mats, String[][] park) {
        parkMap = park;
        xLength = park.length;
        yLength = park[0].length;
        int maxMatSize = 0;
        
        List<Integer> matsList = new ArrayList<>();
        for (int m : mats) {
            matsList.add(m);
        }
        Collections.sort(matsList, Collections.reverseOrder());
        
        for (int mat : matsList) {
            for (int i = 0; i < xLength; i++) {
                for (int j = 0; j < yLength; j++) {
                    if (canSetMat(i, j, mat)) {
                        return mat; // 가장 큰 매트 찾으면 바로 종료
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean canSetMat(int x, int y, int matSize) {
        if (x + matSize > xLength || y + matSize > yLength) {
            return false;
        }
        for (int i = x; i < x + matSize; i++) {
            for (int j = y; j < y + matSize; j++) {
                if (!parkMap[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}