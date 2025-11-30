import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.parseInt(tmp[j]);
            }
            Arrays.sort(dp[i]);
        }

        PriorityQueue<Student> pq = new PriorityQueue<>();
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            // PQ에 각 반마다 제일 작은 학생들 넣기
            pq.offer(new Student(dp[i][0], i, 0));
            // 제일 큰 능력치 값
            maxVal = Math.max(maxVal, dp[i][0]);
        }

        int minDiff = Integer.MAX_VALUE;
        while (true) {
            // 최소 능력치의 학생 뽑기
            Student minStudent = pq.poll();
            // 현재 최대값 차이첮가
            int currentDiff = maxVal - minStudent.ability;
            minDiff = Math.min(minDiff, currentDiff);

            if (minStudent.studentIndex + 1 < m) {
                int nextVal = dp[minStudent.classIndex][minStudent.studentIndex + 1];
                pq.offer(new Student(nextVal, minStudent.classIndex, minStudent.studentIndex + 1));
                maxVal = Math.max(maxVal, nextVal);
                continue;
            }
            break;
        }
        System.out.println(minDiff);
    }

    static class Student implements Comparable<Student> {
        int ability;
        int classIndex;
        int studentIndex;

        public Student(int ability, int classIndex, int studentIndex) {
            this.ability = ability;
            this.classIndex = classIndex;
            this.studentIndex = studentIndex;
        }

        // 학생의 능력치 순으로 오름차순 정렬
        @Override
        public int compareTo(Student o) {
            return this.ability - o.ability;
        }
    }
}