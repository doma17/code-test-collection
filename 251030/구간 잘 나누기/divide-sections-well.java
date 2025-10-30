import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        
        int maxSum = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            maxSum += nums[i];
            maxValue = Math.max(maxValue, nums[i]);
        }

        int answer = Integer.MAX_VALUE;
        for (int limit = maxValue; limit <= maxSum; limit++) {
            boolean isPass = true;
            int partition = 1;
            int curSum = 0;

            for (int j = 0; j < n; j++) {
                if (curSum + nums[j] > limit) {
                    partition++;
                    curSum = nums[j];
                    if (partition > m) {
                        isPass = false;
                        break;
                    }
                } else {
                    curSum += nums[j];
                }
            }

            if (isPass) {
                answer = Math.min(answer, limit);
            }
        }
        System.out.println(answer);
    }
} 