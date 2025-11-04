import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        Stack<Integer> st = new Stack<>();
        boolean is = true;
        try {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                
                if (c == '(') {
                    st.push(1);
                } else if (c == ')') {
                    st.pop();
                }
            }
        } catch(Exception e) {
            System.out.println("No");
            is = false;
        }

        if (st.isEmpty() && is) {
            System.out.println("Yes");
        } else if (is) {
            System.out.println("No");
        }
    }
}