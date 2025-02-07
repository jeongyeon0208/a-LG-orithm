import java.util.*;

class Solution {
    
    public int solution(int[][] triangle) {
        int len = triangle.length;
        
        if(len == 1) return triangle[0][0];
        
        for(int i = len-2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}