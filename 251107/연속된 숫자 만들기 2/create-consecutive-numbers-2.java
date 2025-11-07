import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);

        int ans = 2;
        if (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2]) {
            ans = 0;
        } else if (arr[2] - arr[1] == 1 || arr[1] - arr[0] == 1) {
            ans = 1;
        }
        System.out.println(ans);
    }
}