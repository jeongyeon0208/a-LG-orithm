import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int len = citations.length;
        Arrays.sort(citations);
        
        // 정렬된 배열의 최소값부터 확인
        // 1000 * 10000 = 10,000,000
        for(int h = 0; h <= citations[len-1]; h++){
            int less = 0;
            int more = 0;
            for(int c : citations){
                if(c >= h) more++;
                else less++;
            }
            if(more < h) break;
            if(more >= h && less <= h) answer = h;
        }
        
        return answer;
    }
}