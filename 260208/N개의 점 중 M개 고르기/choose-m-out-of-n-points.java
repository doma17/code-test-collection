import java.util.*;

public class Main {

    static int n, m;
    static int[][] points;
    static boolean[] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        // 점 M개를 적절히 선택하여 가장 먼 두점 사이의 거리가 최소가 되었을 떄, 그때의 최소 거리에 제곱한 값
        // 유클리디안 거리
        choose(0, 0);
        System.out.println(answer);
    }

    private static void choose(int x, int count) {
        if (count == m) {
            int maxDist = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (visited[i] && visited[j]) {
                        maxDist = Math.max(maxDist, (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2)));
                    }
                }
            }
            answer = Math.min(answer, maxDist);
            return;
        }

        for (int i = x; i < n; i++) {
            visited[i] = true;
            choose(i + 1, count + 1);
            visited[i] = false;
        }
    }
}