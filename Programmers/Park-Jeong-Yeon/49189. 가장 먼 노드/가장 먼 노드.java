import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int edgeLen = edge.length;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edgeLen; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            list.get(start).add(end);
            list.get(end).add(start);
        }
        
        
        // 1번 인덱스로부터 떨어진 거리를 저장할 배열
        Integer[] dist = new Integer[n+1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        boolean[] visited = new boolean[n+1];
        
        // 노드의 인덱스를 큐에 넣는다
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        
        while(!queue.isEmpty()){
            int index = queue.poll();
            if(visited[index]) continue;
            visited[index] = true;
            
            List<Integer> list2 = list.get(index);
            
            for(int i = 0; i < list2.size(); i++){     
                int nextIdx = list2.get(i);     
                
                // 만약 방문한 적 없는 노드면 +1
                if (dist[nextIdx] == -1) {
                    dist[nextIdx] = dist[index] + 1;
                    queue.add(nextIdx);
                }
            }
        }   
        
        int maxDist = 0, answer = 0;
        for (int d : dist) {
            if (d > maxDist) {
                maxDist = d;
                answer = 1;
            } 
            else if (d == maxDist) {
                answer++;
            }
        }
        
        return answer;
        
    }
}