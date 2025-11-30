import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();

            String substring = inputArr.substring(1, inputArr.length() - 1);
            if (n > 0) {
                String[] parts = substring.split(",");
                for (String s : parts) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (int j = 0; j < commands.length(); j++) {
                char cmd = commands.charAt(j);

                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (isReversed) {
                        sb.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollLast());
                        }
                    } else {
                        sb.append(deque.pollFirst());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollFirst());
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}