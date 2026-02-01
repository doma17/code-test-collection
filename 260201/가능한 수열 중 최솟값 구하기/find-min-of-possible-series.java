import java.util.*;

public class Main {

    static int answer;
    static int n;

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        arr = new int[n];
        choose(0);
    }

    private static void choose(int idx) {
        if (idx == n) {
            for (int i = 0; i < n; i++) 
                System.out.print(arr[i]);
            System.exit(0);
        }
       
        for (int i = 4; i <= 6; i++) {
            arr[idx] = i;
            if (checkValidation(idx)) {
                choose(idx + 1); 
            }       
        }
    }

    private static boolean checkValidation(int idx) {
        for (int len = 1; len <= (idx + 1) / 2; len++) {    
            boolean isSame = true;
            for (int k = 0; k < len; k++) {
                if (arr[idx - k] != arr[idx - len - k]) {
                    isSame = false;
                    break; 
                }
            }
            if (isSame)
                return false;
        }
        return true;
    }
}