import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;
        
        // round 1
        int[] temp = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (s1 <= i && i <= e1) {
                continue;
            }
            temp[idx++] = blocks[i];
        }
        blocks = temp;

        // round 2
        temp = new int[n];
        idx = 0;
        for (int i = 0; i < n; i++) {
            if (s2 <= i && i <= e2) {
                continue;
            }
            temp[idx++] = blocks[i];
        }
        blocks = temp;

        // size
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (blocks[i] == 0) break;
            size++;
        }
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.println(blocks[i]);
        } 
    }
}