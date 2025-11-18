import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int winColor = 0;
        int winX = -1; 
        int winY = -1; 
        boolean winnerFound = false; 

        for (int j = 0; j < 19; j++) {
            if (winnerFound) break;
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] == 0) continue;
                
                int curColor = arr[i][j];
                
                // 세로
                if (i + 4 < 19) {
                    boolean isWin = true; 
                    for (int k = 1; k < 5; k++) {
                        if (curColor != arr[i + k][j]) {
                            isWin = false;
                            break;
                        }
                    }
                    if (isWin) { 
                        winColor = curColor;
                        winX = i + 3; 
                        winY = j + 1;
                        winnerFound = true;
                        break; 
                    }
                }
                
                // 가로
                if (j + 4 < 19) {
                    boolean isWin = true; 
                    for (int k = 1; k < 5; k++) {
                        if (curColor != arr[i][j + k]) {
                            isWin = false;
                            break;
                        }
                    }
                    if (isWin) {
                        winColor = curColor;
                        winX = i + 1;
                        winY = j + 3;
                        winnerFound = true;
                        break;
                    }
                }
                
                // 오른쪽 아래
                if (i + 4 < 19 && j + 4 < 19) {
                    boolean isWin = true; 
                    for (int k = 1; k < 5; k++) {
                        if (curColor != arr[i + k][j + k]) {
                            isWin = false;
                            break;
                        }
                    }
                    if (isWin) {
                        winColor = curColor;
                        winX = i + 3;
                        winY = j + 3;
                        winnerFound = true;
                        break;
                    }
                }
                
                // 오른쪽 위
                if (i - 4 >= 0 && j + 4 < 19) {
                    boolean isWin = true; 
                    for (int k = 1; k < 5; k++) {
                        if (curColor != arr[i - k][j + k]) {
                            isWin = false;
                            break;
                        }
                    }
                    if (isWin) {
                        winColor = curColor;
                        winX = i - 3;
                        winY = j + 3;
                        
                        winnerFound = true;
                        break;
                    }
                }
            } 
        } 
        
        System.out.println(winColor);
        System.out.println(winX + " " + winY);
    }
}