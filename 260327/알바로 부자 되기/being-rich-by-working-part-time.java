import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int pay = sc.nextInt();
            jobs.add(new Job(start, end, pay));
        }
        Collections.sort(jobs);

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = jobs.get(i).p;
            
            for (int j = 0; j < i; j++) {
                if (jobs.get(j).e < jobs.get(i).s) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs.get(i).p);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }


    static class Job implements Comparable<Job> {
        int s, e, p;

        public Job(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
        
        public int compareTo(Job o) {
            return this.s - o.s;
        }
    }
}