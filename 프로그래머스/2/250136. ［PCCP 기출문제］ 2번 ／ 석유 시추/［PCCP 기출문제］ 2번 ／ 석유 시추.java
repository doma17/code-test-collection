import java.util.*;

class Solution {
    public int solution(int[][] land) {
        bfs(land);
        
        // for (var i : id) {
        //     for (var x : i) System.out.print(x + " ");
        //     System.out.println();
        // }
    
        int answer = 0;
        for (int c = 0; c < land[0].length; c++) {
            // Set을 통해서 이미 추가한 석유 덩어리를 필터링
            Set<Integer> set = new HashSet<>();
            int oil = 0;    
            
            for (int r = 0; r < land.length; r++) {
                if (!set.contains(id[r][c]) && land[r][c] == 1) {
                    oil += map.get(id[r][c]);
                    set.add(id[r][c]);
                }
            }
            answer = Math.max(answer, oil);
        }
        return answer;
    }
    
    private HashMap<Integer, Integer> map;
    private boolean[][] visited;
    private int[][] id;
    
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    
    private void bfs(int[][] land) {
        map = new HashMap<>();
        visited = new boolean[land.length][land[0].length];
        id = new int[land.length][land[0].length];
        int count = 1;
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (visited[i][j] == true || land[i][j] == 0) continue;
                
                Queue<Node> q = new LinkedList<Node>();
                q.add(new Node(i, j));
                // 방문체크, 석유 고유 ID 부여
                visited[i][j] = true;
                id[i][j] = count;
                // 석유량
                int size = 1;
                
                while (!q.isEmpty()) {
                    Node n = q.poll();
                    
                    for (int idx = 0; idx < 4; idx++) {
                        int nextR = n.r + dr[idx];
                        int nextC = n.c + dc[idx];
                        
                        // 필터링 조건
                        if (nextR < 0 || nextR >= land.length || nextC < 0 || nextC >= land[0].length) continue;
                        if (visited[nextR][nextC] || land[nextR][nextC] == 0) continue;
                        
                        q.add(new Node(nextR, nextC));
                        visited[nextR][nextC] = true;
                        id[nextR][nextC] = count;
                        size++;
                    }
                }
                // 각 구역마다 id를 부여해 석유량 저장
                map.put(count, size);
                count++;
            }
        }
    }
    
    class Node {
        int r;
        int c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}