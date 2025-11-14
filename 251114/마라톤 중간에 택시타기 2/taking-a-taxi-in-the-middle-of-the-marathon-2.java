import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        // 모든 경로에 대해 저장
        int[] dist = new int[n - 1];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int distance = Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
            dist[i] = distance;
            sum += distance;
        }
        
        // 하나씩 건너뛰어 보기
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            sum -= dist[i - 1] + dist[i];
            int skipDistance = Math.abs(x[i - 1] - x[i + 1]) + Math.abs(y[i - 1] - y[i + 1]);
            sum += skipDistance;
            minDistance = Math.min(minDistance, sum);
            sum -= skipDistance;
            sum += dist[i - 1] + dist[i];
        }
        System.out.println(minDistance);
    }
}