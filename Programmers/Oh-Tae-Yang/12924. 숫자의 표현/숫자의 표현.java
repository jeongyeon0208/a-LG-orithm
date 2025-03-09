class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum, j;
        //1부터 n까지
        for(int i = 1;i <= n; i++) {
        	sum = 0;
        	sum += i;
        	j = i;
        	while(sum < n+1) {
                j++;
        		sum += j;
        		if(sum == n) answer++;
        	}
        }
        return answer+1;
    }
}