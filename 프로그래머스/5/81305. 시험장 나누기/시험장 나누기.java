class Solution {

    int[] value = new int[10000];
    int[][] child = new int[10000][2];
    int[] parent = new int[10000];
    int root, limit, count;

    public int solution(int k, int[] num, int[][] links) {

        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            parent[i] = -1;
            value[i] = num[i];
            sum += num[i];
        }

        for (int i = 0; i < num.length; i++) {
            child[i][0] = links[i][0];
            if (child[i][0] != -1)
                parent[child[i][0]] = i;
            child[i][1] = links[i][1];
            if (child[i][1] != -1)
                parent[child[i][1]] = i;
        }

        for (int i = 0; i < num.length; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }

        int low = sum / k;
        int high = sum;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, k))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public boolean check(int mid, int k) {
        count = 0;
        limit = mid;
        dfs(root);
        return count < k;
    }

    public int dfs(int node) {
        if (node == -1) return 0;
        if (value[node] > limit) {
            count = 10001;
            return value[node];
        }

        int valueLeft = dfs(child[node][0]);
        int valueRight = dfs(child[node][1]);

        if (valueLeft + valueRight + value[node] <= limit)
            return valueLeft + valueRight + value[node];
        if (valueLeft == 0 || valueRight == 0) {
            count++;
            return value[node];
        }
        if (valueLeft + value[node] <= limit && valueRight + value[node] <= limit) {
            count++;
            return valueLeft < valueRight ? valueLeft + value[node] : valueRight + value[node];
        }
        if (valueLeft + value[node] <= limit) {
            count++;
            return valueLeft + value[node];
        }
        if (valueRight + value[node] <= limit) {
            count++;
            return valueRight + value[node];
        }
        count += 2;
        return value[node];
    }
}