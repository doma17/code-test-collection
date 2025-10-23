import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] weight = new int[n];

        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            int num = i + 1;
            
            pq.add(new Student(height[i], weight[i], num));
        }
        
        while(!pq.isEmpty()) {
            pq.poll().printContext();
        }
    }
}


class Student implements Comparable<Student> {
    int height, weight, number;

    public Student(int height, int weight, int number){
        this.height = height;
        this.weight = weight;
        this.number = number;
    }

    @Override
    public int compareTo(Student s) {
        if (this.height != s.height) return s.height- this.height;
        if (this.weight != s.weight) return s.weight - this.weight;
        return this.number - s.number;
    }

    public void printContext() {
        System.out.println(height + " " + weight + " " + number);
    }
};