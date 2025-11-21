import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if (command.equals("push_back")) {
                list.add(Integer.parseInt(sc.next()));
            } else if (command.equals("get")) {
                System.out.println(list.get(Integer.parseInt(sc.next()) - 1));
            } else if (command.equals("pop_back")) {
                list.remove(list.size() - 1);
            } else if (command.equals("size")) {
                System.out.println(list.size());
            }
        }
    }
}