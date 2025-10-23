import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            pq.add(new Student(name, score1, score2, score3));
        }
        
        while(!pq.isEmpty()) {
            pq.poll().printContext();
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {  // 총 점수 기준 오름차순 정렬
        return (this.kor + this.eng + this.math) - (student.kor + student.eng + student.math);
    }

    public void printContext() {
        System.out.println(name + " " + kor + " " + eng + " " + math);
    }
};