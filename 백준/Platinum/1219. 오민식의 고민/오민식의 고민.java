import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int n, m, startCity, endCity;
    static ArrayList<Edge> edges;
    static long[] distance;
    static long[] cityPay;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        startCity = Integer.parseInt(tmp[1]);
        endCity = Integer.parseInt(tmp[2]);
        m = Integer.parseInt(tmp[3]);

        edges = new ArrayList<>();
        distance = new long[n];
        Arrays.fill(distance, Integer.MIN_VALUE);
        
        for (int i = 0; i < m; i++) {
            tmp = br.readLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            // 교통 비용을 음수 값으로 삽입
            edges.add(new Edge(start, end, -cost)); 
        }

        cityPay = new long[n];
        tmp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cityPay[i] = Integer.parseInt(tmp[i]);
        }

        bellmanFord();
    }

    static void bellmanFord() {
        distance[startCity] = cityPay[startCity];

        // n번 만큼 추가로 진행해 양수 사이클을 파악
        for (int i = 1; i < n * 2; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges.get(j);

                if (distance[edge.start] == Integer.MAX_VALUE) {
                    // 양수 사이클 전파
                    distance[edge.end] = Integer.MAX_VALUE;
                }

                if (distance[edge.start] == Integer.MIN_VALUE) continue;
                // 도시에서 버는 돈을 추가해서 계산
                if (distance[edge.end] < distance[edge.start] + edge.cost + cityPay[edge.end]) {
                    if (i >= n) {
                        // 양수 사이클
                        distance[edge.end] = Integer.MAX_VALUE;
                    } else {
                        distance[edge.end] = distance[edge.start] + edge.cost + cityPay[edge.end];
                    }
                }
            }
        }
        
        if (distance[endCity] == Integer.MIN_VALUE) {
            // 도착하는 것이 불가능
            System.out.println("gg");
        } else if (distance[endCity] == Integer.MAX_VALUE) {
            // 무한이 돈을 벌 수 있음
            System.out.println("Gee");
        } else {
            // 최대로 벌 수 있는 돈
            System.out.println(distance[endCity]);
        }
    }

    static class Edge {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}