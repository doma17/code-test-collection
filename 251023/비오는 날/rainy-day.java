import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            // Please write your code here/.
            String[] dateString = date.split("-");
            if (weather.equals("Rain")) {
                pq.add(new Node(
                    Integer.parseInt(dateString[0]),
                    Integer.parseInt(dateString[1]),
                    Integer.parseInt(dateString[2]),
                    day,
                    weather
                ));
            }
        }
        if (!pq.isEmpty()) pq.poll().getFastestDateAndWeather();
    }

    static class Node implements Comparable<Node> {
        int year;
        int month;
        int day;

        String dayString;
        String weather;

        public Node(int year, int month, int day, String dayString, String weather) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.dayString = dayString;
            this.weather = weather;
        }

        public int compareTo(Node o) {
            if (this.year != o.year) return this.year - o.year;
            else if (this.month != o.month) return this.month - o.month;
            else return this.day - o.day;
        }

        public void getFastestDateAndWeather() {
            String dateFormatted = String.format("%d-%02d-%02d", year, month, day);
            System.out.println(dateFormatted + " " + dayString + " " + weather);
        }
    }
}