import java.util.*;

class Solution {
   
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int size = rocks.length;
        
        Arrays.sort(rocks);
        
        int[] dist = new int[size+1];
        
        // 초기 각 바위 사이 거리
        dist[0] = rocks[0];
        for(int i = 1; i < size; i++) dist[i] = rocks[i] - rocks[i-1];
        dist[size] = distance - rocks[size-1];
        
        int start = 1;
        int end = distance;
        
        while(start <= end){
            int mid = (start + end)/2;
            
            // 몇개 제거했는지 담을 변수
            int count = 0;
            
            // 거리의 합을 담을 변수
            int sum = 0;
            
            
            for(int i = 0; i < size + 1; i++){
                sum += dist[i];
                if(sum < mid){
                    count++;
                    continue;
                }
                // 만약 sum이 mid보다 크거나 같으면 제거할 필요 없으므로 sum = 0 으로 재시작
                sum = 0;
            }
        
            // n개를 제거해서 mid값이 최소가 되게 해야되는데 더 많이 제거했으므로 mid를 줄여됨
            if(count > n) {
                end = mid - 1;
                continue;
            }
            
            // count < n이라면 mid를 증가시켜야됨
            // count == n 일지라도 mid가 정답이 아닐 수도 있으므로 mid를 증가시킨다.
            // 만약 mid를 증가시켰는데 이전 mid가 정답이라면 다시 돌아올 것
            start = mid + 1;
            answer = Math.max(answer, mid);
        }
        
        return answer;
        
    }
}