import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        
        int[][] sum = new int[n][n];
        sum[0][n - 1] = matrix[0][n - 1];
        
        for (int j = n - 2; j >= 0; j--)
            sum[0][j] = sum[0][j + 1] + matrix[0][j];
        for (int i = 1; i < n; i++) 
            sum[i][n - 1] = sum[i - 1][n - 1] + matrix[i][n - 1];
        
        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j + 1]) + matrix[i][j];
            }
        }
        System.out.println(sum[n - 1][0]);
    }
}