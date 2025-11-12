import java.util.*;

class Solution {
    
    public String solution(String p) {
        if (p.isEmpty()) return "";
        if (isRight(p)) return p; 
        return process(p);
    }

    String process(String w) {
        if (w.isEmpty()) return "";

        String u = "";
        String v = "";
        int balance = 0; 
        
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') balance++;
            else balance--;
            
            if (balance == 0) {
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break; 
            }
        }

        if (isRight(u)) {
            return u + process(v); 
        } 
        else {
            String temp = "(" + process(v) + ")";
            String innerU = u.substring(1, u.length() - 1);
            temp += reverseString(innerU); 
            return temp;
        }
    }

    String reverseString(String u) {
        if (u.isEmpty()) return "";

        char[] arr = u.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (var c : arr) {
            if (c == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }

    boolean isBalance(String p) {
        if (p.isEmpty()) return true; 
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;
        }
        return cnt == 0;
    }

    boolean isRight(String p) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false; 
                st.pop();
            }
        }
        return st.isEmpty(); 
    }
}