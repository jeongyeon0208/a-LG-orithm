import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        List<Integer> list = new LinkedList<>();
        Queue<Process> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            list.add(priorities[i]);
            q.add(new Process(priorities[i], i));
        }
        
        Collections.sort(list);
        int n = list.size();
        
        while(!q.isEmpty()) {
            Process p = q.poll();
            
            if(p.priority < list.get(n-1)) {
                q.add(p);
                continue;
            }
            
            if(p.location == location) {
                answer = list.size() - n + 1;
                break;
            }
            
            n--;
        }
        
        return answer;
    }
    
    public class Process {
        int priority;
        int location;
        
        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}