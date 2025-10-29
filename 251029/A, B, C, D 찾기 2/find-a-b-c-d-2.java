import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = arr[14];

        int a = arr[0];
        int b = arr[1];
        int c = 0;

        if (a + b == arr[2]) c = arr[3];
        else c = arr[2];

        int d = arr[14] - a - b - c;
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}