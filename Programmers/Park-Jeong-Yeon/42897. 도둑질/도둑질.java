import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 첫 번째 집을 털었을 경우
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {  // 마지막 집을 털지 않음
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }
        
        // 첫 번째 집을 털지 않았을 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < n; i++) {  // 마지막 집을 털 수 있음
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }
        
        return Math.max(dp1[n - 2], dp2[n - 1]); // 두 경우 중 최대값 반환
    }
}