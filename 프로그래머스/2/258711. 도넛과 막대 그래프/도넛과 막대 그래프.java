import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        HashMap<Integer, Integer> out = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        int[] answer = new int[4];
        
        for (var edge : edges) {
            int a = edge[0];
            int b = edge[1];    
            out.put(a, out.getOrDefault(a, 0) + 1);
            in.put(b, in.getOrDefault(b, 0) + 1);
        }
        
        for (var vertex : out.keySet()) {
            if (out.get(vertex) >= 2) {
                if (!in.containsKey(vertex)) {
                    // 생성된 초기 정점
                    answer[0] = vertex;
                } else {
                    // 8자 그래프
                    answer[3]++;
                }
            }
        }
        
        for (int vertex : in.keySet()) {
            if (!out.containsKey(vertex)) {
                // 막대 그래프
                answer[2]++;
            }
        }
        
        // 도넛개수 = 전체 정점 개수 - 막대개수 - 8자개수
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}