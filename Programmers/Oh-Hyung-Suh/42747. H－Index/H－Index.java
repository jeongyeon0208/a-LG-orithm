/*
 * h <= n
 * 발표한 논문 수랑 인용 횟수가 이상함(?)
 * 100편 중, 30번 이상 인용된 논문이 30편 이상
 * 30편 중, 100번 이상 인용된 논문이 100편 이상.. 이상하니까 0이 되는거여.. 아닌가
 */

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++) {
            // i가 작을 수록 최대 H가 구해진다
            int h = n - i;
            
            // 오름차순 정렬이므로 citations[i]가 h번 이상 인용된 경우, i+1 부터는 모두 h번 이상 인용된다.
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}