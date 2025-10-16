import java.util.*;

class Solution {

    // 로봇이 목적지에 도착
    boolean isAllArrived = false;
    boolean[] isArrived;
    int[] curRouteIndex;

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        // 로봇별 현재 경로 인덱스
        curRouteIndex = new int[routes.length];
        Arrays.fill(curRouteIndex, 1);

        isArrived = new boolean[routes.length];
        // 로봇별 초기 좌표값
        int[][] curCoord = new int[routes.length][2];
        for (int i = 0; i < routes.length; i++) {
            int point = routes[i][0] - 1;
            curCoord[i][0] = points[point][0];
            curCoord[i][1] = points[point][1];
        }
        // 로봇 초기 위치 겹침 확인
        answer += calculateRobotLocation(curCoord);

        while (!isAllArrived) {
            // 로봇 이동
            for (int i = 0; i < curCoord.length; i++) {
                if (!isArrived[i]) {
                    curCoord[i] = move(curCoord[i], i, points, routes);
                }
            }
            // 로봇 위치 겹침 확인
            answer += calculateRobotLocation(curCoord);
            // 로봇 최종 목적지 도착 판단
            calculateArrived();
        }

        return answer;
    }

    private int[] move(int[] curCoord, int robot, int[][] points, int[][] routes) {
        int curX = curCoord[0];
        int curY = curCoord[1];
        int targetX = points[routes[robot][curRouteIndex[robot]] - 1][0];
        int targetY = points[routes[robot][curRouteIndex[robot]] - 1][1];
        
        // 다음 목적지에 도착
        if (curX == targetX && curY == targetY) {
            if (curRouteIndex[robot] == routes[robot].length - 1) {
                // 마지막 목적지 도착
                isArrived[robot] = true;
            } else {
                curRouteIndex[robot]++;
            }
            targetX = points[routes[robot][curRouteIndex[robot]] - 1][0];
            targetY = points[routes[robot][curRouteIndex[robot]] - 1][1];
        }

        if (targetX - curX != 0) {
            if (targetX - curX > 0) curX++;
            else curX--;
        } else {
            if (targetY - curY > 0) curY++;
            else curY--;
        }

        return new int[] {curX, curY};
    }

    private int calculateRobotLocation(int[][] curCoord) {
        // 로봇 위치 겹침 확인
        Map<String, Integer> coordCounts = new HashMap<>();
        int currentDanger = 0;

        // 모든 로봇의 위치를 맵에 카운트 (최종 도착 로봇 제외)
        for (int i = 0; i < curCoord.length; i++) {
            if (isArrived[i]) continue; // 최종 도착한 로봇은 제외

            String coord = curCoord[i][0] + "," + curCoord[i][1];
            coordCounts.put(coord, coordCounts.getOrDefault(coord, 0) + 1);
        }
        // 두대 이상 모인 좌표의 개수 세기
        for (int count : coordCounts.values()) {
            if (count >= 2) {
                currentDanger++;
            }
        }
        return currentDanger;
    }

    private void calculateArrived() {
        boolean allArrived = true;
        for (boolean arrived : isArrived) {
            if (!arrived) {
                allArrived = false;
                break;
            }
        }
        isAllArrived = allArrived;
    }
}