import java.util.*;


class Solution {
    static class Position{
        int p;
        int l;
        
        public Position(int p, int l){
            this.p=p;
            this.l=l;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // priority와 index를 큐에 넣는다.
        Queue<Position> q1 = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            q1.add(new Position(priorities[i], i));
        }
        
        
        while(!q1.isEmpty()){
            boolean b = false;
            Position tempPosition = q1.poll();
            // 나머지 큐에서 poll하면서 자기보다 큰게 있는지 확인한다.
            for(int i = 0; i < q1.size(); i++){
                Position nextPosition = q1.poll();
                // 자기보다 큰게 있으면 b = true
                if(nextPosition.p > tempPosition.p) b = true;
                q1.offer(nextPosition);
            }
            // 자기보다 큰게 있었으므로 다시 큐에 넣는다
            if(b) q1.offer(tempPosition);
            // 자기보다 큰게 없으면 answer++
            // 자기의 위치가 location과 일치하면 return answer
            else{
                answer++;
                if(tempPosition.l == location) return answer;
            }
            
        }
        
        return 0;
        
    }
}