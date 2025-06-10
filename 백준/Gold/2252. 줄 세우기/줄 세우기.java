import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] edge;
    static int[] degree;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // INPUT
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        edge = new ArrayList[32001];
        degree = new int[32001];
        ans = new ArrayList<>();
        
        for(int i = 0; i <= 32000; i++) {
            edge[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edge[a].add(b);
            degree[b]++;
        }
        
        topologicalSort();
        
        // OUTPUT
        StringBuilder sb = new StringBuilder();
        for(int x : ans) {
            sb.append(x).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
            if(degree[i] != 0) continue;
            q.offer(i);
        }
        
        // DAG 위상정렬
        while(!q.isEmpty()) {
            int now = q.poll();
            ans.add(now);
            
            for(int next : edge[now]) {
                degree[next]--;
                
                if(degree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
    
   
}