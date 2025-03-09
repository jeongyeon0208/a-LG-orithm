import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 이중 리스트(?) 초기화
        List<List<Integer>> graph = new ArrayList<>(n);
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향이므로 양쪽에 넣어주기
        for(int[] e : edge) {
            int a = e[0] - 1;
            int b = e[1] - 1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 방문한 곳 체크하기
        // 안 하면 무한 루프
        boolean[] visited = new boolean[n];
        
        // 각 노드 최단 거리 배열
        int[] depth = bfs(n, visited, graph);
        
        // 최단 거리 배열 중 가장 멀리 간 노드 개수 구하기
        return getAnswer(depth);
    }
    
    // 최대 깊이 최신화 시켜주면서 그 깊이랑 길이가 같은 것들 값 1씩 더하기
    private int getAnswer(int[] depth) {
        int maxDepth = 0;
        int answer = 0;
        
        for(int d : depth) {
            if(d == maxDepth) {
                answer++;
            } else if(maxDepth < d) {
                maxDepth  = d;
                answer = 1;
            }
        }
        
        return answer;
    }
    
    private int[] bfs(int n, boolean[] visited, List<List<Integer>> graph) {
        int depth[] = new int[n];
        Queue<int[]> q = new LinkedList<>();
        
        // 시작할 노드와 깊이 0 지정
        q.add(new int[]{0, 0});
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int[] nodeInfo = q.poll();
            
            // 현재 노드와 그 노드의 깊이 꺼내기
            // 방문 안 한 곳을 처음 들린 값이 최소값이므로 depth에 저장
            int node = nodeInfo[0];
            int deep = nodeInfo[1];
            depth[node] = deep;
            
            // 현재 노드와 연결된 다음 노드가 방문하지 않았다면 q에 넣어주기
            for(int i = 0; i < graph.get(node).size(); i++) {
                int nextNode = graph.get(node).get(i);
                
                if(!visited[nextNode]) {
                    q.add(new int[]{nextNode, deep + 1});
                    visited[nextNode] = true;
                }
            }
        }
        
        return depth;
    }
}