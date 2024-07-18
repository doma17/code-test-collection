class Solution {
    public int solution(int chicken) {
        int answer = 0;

        int coupon = chicken;
        while (coupon >= 10) {
            chicken = coupon / 10;
            coupon %= 10;
            coupon += chicken;
            answer += chicken;
        }

        return answer;
    }
}