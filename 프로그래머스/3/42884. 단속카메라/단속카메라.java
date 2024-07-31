import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (x, y) -> x[1] - y[1]);

        int cam = 1;
        int lastCamIndex = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > lastCamIndex || lastCamIndex > routes[i][1]) {
                lastCamIndex = routes[i][1];
                cam++;
            }
        }
        return cam;
    }
}