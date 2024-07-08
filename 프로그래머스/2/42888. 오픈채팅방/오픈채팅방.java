import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> hashMap = new HashMap<>();
        int nameChangeCount = 0;

        for(String row : record) {
            String[] str = row.split(" ");

            if (str[0].equals("Enter")) {
                hashMap.put(str[1], str[2]);
            } else if (str[0].equals("Change")) {
                hashMap.put(str[1], str[2]);
                nameChangeCount++;
            }
        }

        String[] answer = new String[record.length - nameChangeCount];
        int i = 0;

        for(String row : record) {
            String[] str = row.split(" ");
            String name = hashMap.get(str[1]);

            if (str[0].equals("Enter")) {
                answer[i++] = name + "님이 들어왔습니다.";
            } else if (str[0].equals("Leave")) {
                answer[i++] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}