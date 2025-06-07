import java.io.*;
import java.util.*;

public class Main {

    // Default Setting Object
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int A, B, C;
    static boolean[][][] visited;
    static Set<Integer> result;

    public static void main(String[] args) throws IOException {
        // Init
        String[] tmp = br.readLine().split(" ");
        A = Integer.parseInt(tmp[0]);
        B = Integer.parseInt(tmp[1]);
        C = Integer.parseInt(tmp[2]);

        visited = new boolean[A + 1][B + 1][C + 1];
        result = new TreeSet<>(); // 자동 정렬

        // Process
        bfs();

        // Output
        for (int water : result) {
            sb.append(water).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, C));
        visited[0][0][C] = true;

        while (!q.isEmpty()) {
            State current = q.poll();
            int a = current.a;
            int b = current.b;
            int c = current.c;

            if (a == 0) {
                result.add(c);
            }

            // 6가지 물 붓기 연산
            // A → B
            pourWater(q, Math.max(0, a - (B - b)), Math.min(B, a + b), c);
            
            // A → C
            pourWater(q, Math.max(0, a - (C - c)), b, Math.min(C, a + c));
            
            // B → A
            pourWater(q, Math.min(A, a + b), Math.max(0, b - (A - a)), c);
            
            // B → C
            pourWater(q, a, Math.max(0, b - (C - c)), Math.min(C, b + c));
            
            // C → A
            pourWater(q, Math.min(A, a + c), b, Math.max(0, c - (A - a)));
            
            // C → B
            pourWater(q, a, Math.min(B, b + c), Math.max(0, c - (B - b)));
        }
    }

    static void pourWater(Queue<State> q, int newA, int newB, int newC) {
        if (!visited[newA][newB][newC]) {
            visited[newA][newB][newC] = true;
            q.add(new State(newA, newB, newC));
        }
    }

    static class State {
        int a, b, c;

        State(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
 }