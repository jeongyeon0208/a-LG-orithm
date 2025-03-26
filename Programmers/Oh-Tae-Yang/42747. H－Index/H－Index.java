import java.util.*;

/*
1. H의 값을 미리 정하는 것이 키 포인트
2. 정렬한 후, 인덱스 위치에 따라서 해당 위치보다는 전부 큰 값이 있는 것임을 판단
3. 인용된 횟수를 확인하며 처음으로 H번 이상 인용된 데이터가 나오면 break
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