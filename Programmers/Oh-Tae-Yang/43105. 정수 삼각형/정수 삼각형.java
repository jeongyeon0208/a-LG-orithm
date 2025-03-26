class Solution {
    static int [][] dp;
    static boolean [][] vistied;
    public static int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        dp = new int[len][len];
        vistied = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[len - 1][i] = triangle[len - 1][i];
        }

        return topDown(triangle, 0, 0);
    }
    public static int topDown(int[][] triangle, int n, int m) {
        if (n == triangle.length - 1) {
            vistied[n][m] = true;
            return dp[n][m];
        }
        if (vistied[n][m]) {
            return dp[n][m];
        }
        dp[n][m] = triangle[n][m] + Math.max(topDown(triangle, n+1, m), topDown(triangle, n+1, m +1));
        vistied[n][m] = true;
        return dp[n][m];
    }
}