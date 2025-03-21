import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i : queue1) q1.add(i);
        for(int i : queue2) q2.add(i);
        
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i : queue1) sum1+= i;
        for(int i : queue2) sum2+= i;
        if((sum1 + sum2 )%2 != 0) return -1;
        
        // 무조건 큰쪽에서 하나 빼기
        int i = 0;
        while(i <= 600000){
            
            if(sum1 > sum2) {
                int move = q1.poll();
                q2.add(move);
                answer++;
                
                sum1 -= move;
                sum2 += move;
            }
            else if (sum1 < sum2){
                int move = q2.poll();
                q1.add(move);
                answer++;
                
                sum2 -= move;
                sum1 += move;
            }
            else return answer;
            
            i++;
        }
        
        return -1;
    }
}