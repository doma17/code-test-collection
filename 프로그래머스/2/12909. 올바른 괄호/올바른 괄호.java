import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        
        if (arr[0] == ')') {
            return false;
        }
        Stack<String> st = new Stack<>();
        for (var x : arr) {
            if (x == '(') {
                st.push(String.valueOf(x));
            } else {
                if (st.empty()) {
                    return false;
                } else { 
                    st.pop();
                }
            }
        }
        
        if (st.empty()) {
            return true;    
        } 
        return false;
    }
}