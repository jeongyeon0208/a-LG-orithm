import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1, right = distance;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int removeRocks = getRemoveRocks(rocks, distance, mid);
            
            if(removeRocks > n) {
                right = mid - 1;
            }else {
                answer = mid;
                left = mid + 1;
            }
            
        }
        
        return answer;
    }
    
    private int getRemoveRocks(int[] rocks, int distance, int mid) {
        int tmp = 0;
        int removeRocks = 0;
        
        for(int rock : rocks) {
            if(rock - tmp < mid) {
                removeRocks++;
                continue;
            }
            tmp = rock;
        }
        
        if(distance - tmp < mid) {
            removeRocks++;
        }
        
        return removeRocks;
    }
}