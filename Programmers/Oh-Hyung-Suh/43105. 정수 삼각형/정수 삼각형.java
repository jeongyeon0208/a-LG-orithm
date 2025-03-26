import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        if(n == 1) {
            return triangle[0][0];
        }
        
        if(n == 2) {
            return triangle[0][0] + Math.max(triangle[1][0], triangle[1][1]);
        }
        
        int[][] dp = init(n, triangle);
        
        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }
        
        return Arrays.stream(dp[n-1]).reduce(Integer::max).getAsInt();
    }
    
    private int[][] init(int n, int[][] triangle) {
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        return dp;
    }
}