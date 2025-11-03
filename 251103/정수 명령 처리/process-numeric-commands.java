import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("push")) {
                int input = sc.nextInt();
                s.push(input);
            } else if (command.equals("size")) {
                System.out.println(s.size());
            } else if (command.equals("empty")) {
                if (s.empty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("pop")) {
                System.out.println(s.pop());
            } else if (command.equals("top")) {
                System.out.println(s.peek());
            }
        }
    }
}