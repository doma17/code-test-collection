import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> missScoreMap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            missScoreMap.put(name[i], yearning[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (String[] humans : photo) {
            int sum = 0;
            for (var n : humans) {
                Integer score = missScoreMap.get(n);
                if (score != null) sum += score;
            }
            list.add(sum);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}