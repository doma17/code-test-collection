import java.util.*;

public class Solution {

    private Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    private int answer;

    public int solution(int[] info, int[][] edges) {
        for (int[] e : edges) {
            int parent = e[0];
            int child = e[1];

            if (!map.containsKey(parent)) map.put(parent, new ArrayList<>());
            map.get(parent).add(child);
        }

        List<Integer> next = new LinkedList<>();
        next.add(0);
        dfs(info, next, 0, 0, 0);

        return answer;
    }

    // 아래 과정에 대한 해설
    /*
    1. 현재 노드가 양이면 sheep를 1 증가시키고, 늑대면 wolf를 1 증가시킨다.
    2. 만약 양의 수가 늑대의 수보다 작거나 같다면 return한다.
    3. 현재 양의 수가 늑대의 수보다 크다면 answer를 갱신한다.
    4. 다음 노드를 탐색하기 위해 next 리스트를 생성하고, 현재 노드의 자식 노드들을 추가한다.
    5. next 리스트에서 현재 노드를 제거한다.
    6. next 리스트에 대해 반복문을 수행하며, dfs를 호출한다.
     */
    public void dfs(int[] info, List<Integer> list, int node, int sheep, int wolf) {
        if (info[node] == 0) sheep += 1;
        else wolf += 1;
        if (sheep <= wolf) return;
        answer = Math.max(answer, sheep);

        List<Integer> next = new ArrayList<>(list);
        if (map.containsKey(node)) {
            next.addAll(map.get(node));
        }
        next.remove(Integer.valueOf(node));

        for (int n : next) {
            dfs(info, next, n, sheep, wolf);
        }
    }
}