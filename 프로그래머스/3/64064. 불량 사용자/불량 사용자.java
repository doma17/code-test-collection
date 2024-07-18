import java.util.*;

class Solution {

    boolean[] visited;
    HashSet<String> set;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        set = new HashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        dfs(0, "", banned_id, user_id);

        return set.size();
    }


    public void dfs(int depth, String res, String[] bannedIds, String[] userIds) {
        if (depth == bannedIds.length) {
            String[] arr = res.split(" ");
            Arrays.sort(arr);
            
            StringBuilder sb = new StringBuilder();
            for (String s : arr) sb.append(s);

            set.add(sb.toString());

            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (visited[i]) continue;
            if (!userIds[i].matches(bannedIds[depth])) continue;

            visited[i] = true;
            dfs(depth + 1, userIds[i] + " " + res, bannedIds, userIds);
            visited[i] = false;
        }
    }
}