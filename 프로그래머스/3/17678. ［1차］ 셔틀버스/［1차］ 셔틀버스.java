import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            String[] x = timetable[i].split(":");
            pq.add(Integer.parseInt(x[0]) * 60 + Integer.parseInt(x[1]));
        }

        int busTime = 9 * 60;
        List<Integer>[] bus = new List[n];
        for (int i = 0; i < n; i++) {
            bus[i] = new ArrayList<>();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty()) {
                int crewTime = pq.poll();

                if (bus[i].size() < m && crewTime <= busTime) {
                    bus[i].add(crewTime);
                } else {
                    pq.add(crewTime);
                    break;
                }
                cnt = crewTime - 1;
            }
            busTime += t;
        }

        if (bus[n - 1].size() < m)
            cnt = busTime - t;

        String hour = String.format("%02d", cnt / 60);
        String min = String.format("%02d", cnt % 60);

        return hour + ":" + min;
    }
}