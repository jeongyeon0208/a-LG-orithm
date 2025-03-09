class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            // n을 표현할 수의 개수로 나눈 값 - 표현할 수의 개수/2
            for(int j = (int)(n/i - i/2); j <= (int)(n/i - i/2) + 1; j++){
                // 만약 첫 숫자가 음수면 계산 X
                if(j <= 0) continue;
                
                int sum = 0;
                for(int k = 0; k < i; k++) sum += j+k;
                if (sum == n) answer ++;  
                if (sum >= n) break;
            }
        }
        
        
        return answer;
    }
}