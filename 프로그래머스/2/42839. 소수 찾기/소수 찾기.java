import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] numbersArr;

    public int solution(String numbers) {
        numbersArr = numbers.toCharArray();
        visited = new boolean[numbersArr.length];

        dfs("", 0);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    private void dfs(String currentNum, int depth) {
        if (!currentNum.isEmpty()) set.add(Integer.parseInt(currentNum));

        for (int i = 0; i < numbersArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(currentNum + numbersArr[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}