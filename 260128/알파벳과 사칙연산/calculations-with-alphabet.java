import java.util.*;

public class Main {

    static ArrayList<Integer> varList = new ArrayList<>();
    static ArrayList<Character> opsList = new ArrayList<>();
    static int[] arr = new int[7];

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                opsList.add(c);
                continue;
            }
            arr[c - 'a'] = -1;
            varList.add(c - 'a');
        }
        
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == 6) {
            calc();
            return;
        } else if (arr[depth] == 0) {
            dfs(depth + 1);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    static void calc() {
        int cur = arr[varList.get(0)];

        for (int i = 0; i < opsList.size(); i++) {
            char ops = opsList.get(i);
            int next = arr[varList.get(i + 1)];

            if (ops == '+') {
                cur += next;
            } else if (ops == '-') {
                cur -= next;
            } else if (ops == '*') {
                cur *= next;
            }
        }
        answer = Math.max(answer, cur);
    }
}