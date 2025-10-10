import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (var name : callings) {
            int idx = map.get(name);
            
            String tmp = players[idx - 1];
            players[idx - 1] = players[idx];
            players[idx] = tmp;
            
            map.remove(name);
            map.remove(tmp);
            
            map.put(name, idx - 1);
            map.put(tmp, idx);
        }
        
        return players;
    }
}