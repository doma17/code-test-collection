import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // 테이블 정렬
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[col - 1] == a2[col - 1] ?  a2[0] - a1[0] : a1[col - 1] - a2[col - 1];
            }
        });
        
        // for (var arr : data) {
        //     for (var x : arr) System.out.print(x + " ");
        //     System.out.println();
        // }
        
        int sum = 0;
        for (var row : data[row_begin - 1]) {
            sum += row % (row_begin);
            // System.out.println(sum + " <- " + row + " % " + row_begin);
        }
        answer = sum;
        // System.out.println(answer);
        
        for (int i = row_begin; i < row_end; i++) {
            sum = 0;
            for (var row : data[i]) {
                sum += row % (i + 1);
            }
            answer = answer ^ sum;
        }
        // System.out.println(answer);
        
        return answer;
    }
}