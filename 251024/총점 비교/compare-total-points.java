import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
        }
        // Please write your code here.
    }
}

class Student implements Comparable<Student> {
    int kor, eng, math;

    public Student(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student) {  // 총 점수 기준 오름차순 정렬
        return (this.kor + this.eng + this.math) - (student.kor + student.eng + student.math);
    }
};