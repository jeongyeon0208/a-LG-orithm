class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int start = 1, end = 1, sum = 1;
            
        while(end < n) {
            if(sum < n) {
                sum += ++end;
                
            }else {
                sum -= start++;
            }
            
            if(sum == n) {
                answer++;
            }
        }
        
        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 1;
        
//         if(n == 1 || n == 2) {
//             return answer;
//         }
        
//         int start = 1, end = 1;
//         int max = n / 2 + 2;
//         int sum = 0;
            
//         while(end <= max) {
//             if(sum < n) {
//                 sum += end;
//                 end++;
                
//             }else if(n <= sum) {
//                 sum -= start;
//                 start++;
//             }
            
//             if(sum == n) {
//                 answer++;
//                 sum -= start;
//                 start++;
//             }
//         }
        
//         return answer;
//     }
// }