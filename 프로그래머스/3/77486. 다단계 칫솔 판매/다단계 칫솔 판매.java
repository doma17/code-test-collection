import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, Node> map = new HashMap<>();
        for (String e : enroll)
            map.put(e, new Node(e, null, 0));

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) continue;
            map.get(enroll[i]).parent = map.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++)
            map.get(seller[i]).shareProfit(amount[i] *  100);

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).profit;
        }
        return answer;
    }
}

class Node {
    String name;
    Node parent;
    int profit;

    public Node(String name, Node parent, int profit) {
        this.name = name;
        this.parent = parent;
        this.profit = profit;
    }

    public void shareProfit(int profit) {
        int share = profit / 10;
        this.profit += profit - share;

        if (this.parent == null) return;
        if (share < 1) return;

        this.parent.shareProfit(share);
    }
}