import java.util.*;

class Solution {
    
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = -1;
    
    static class Pair{
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static Queue<Pair> queue = new LinkedList<>();
    
    static void bfs(){
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m ||
                visited[newX][newY] || arr[newX][newY] == 0) continue;
                arr[newX][newY] += arr[x][y];
                visited[newX][newY] = true;
                if(newX == n-1 && newY == m-1) answer = arr[newX][newY];
                queue.add(new Pair(newX, newY));
            }
        }
        
    }
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        arr = maps;
        visited = new boolean[n][m];
        
        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        bfs();

        if(!visited[n-1][m-1]) return -1;
        return answer;
    }
}