class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder ans = new StringBuilder();
        // 0은 11로 치환
        // 왼손 시작 위치 10, 오른손 시작 위치 12
        int left = 10, right = 12;

        for (int num : numbers) {
            if (num == 0)
                num = 11;
            if (num == 1 || num == 4 || num == 7) {
                left = getLeft(num, ans);
            } else if (num == 3 || num == 6 || num == 9) {
                right = getRight(num, ans);
            } else {
                int leftDist = getDist(num, left);
                int rightDist = getDist(num, right);

                if (leftDist == rightDist) {
                    if (hand.equals("left")) {
                        left = getLeft(num, ans);
                    } else {
                        right = getRight(num, ans);
                    }
                } else if (leftDist < rightDist) {
                    left = getLeft(num, ans);
                } else {
                    right = getRight(num, ans);
                }
            }
        }
        return ans.toString();
    }

    private static int getLeft(int num, StringBuilder ans) {
        ans.append("L");
        return num;
    }

    private static int getRight(int num, StringBuilder ans) {
        ans.append("R");
        return num;
    }

    private static int getDist(int num, int left) {
        return Math.abs((left - 1) / 3 - (num - 1) / 3) 
                + Math.abs((left - 1) % 3 - (num - 1) % 3);
    }
}