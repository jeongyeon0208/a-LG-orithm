class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int max1 = dp(money, 0, n-1);
        int max2 = dp(money, 1, n);

        return Math.max(max1, max2);
    }
    
    public static int dp(int[] money, int start, int finish) {
        int [] dp = new int [money.length];
        if (start == 1) {
            dp[start] = money[start];
        } else {
            dp[start] = money[start];
            dp[start + 1] = Math.max(money[start], money[start + 1]);
        }
        for (int i = 2; i < finish; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        return dp[finish -1];
    }
}