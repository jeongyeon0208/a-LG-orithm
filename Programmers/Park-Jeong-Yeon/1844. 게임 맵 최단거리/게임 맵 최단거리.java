import java.util.*;

class Solution {
    static boolean[][] visited;
    
    static int row;
    static int col;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    static class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int bfs(Position position, int[][] maps){
        
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        
        while(!queue.isEmpty()){
            Position temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            
            if(x == row - 1 && y == col - 1) return maps[x][y];
            
            visited[x][y] = true;
        
            for(int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if(newX < 0 || newX > row-1 || 
                   newY < 0 || newY > col-1) continue;
                
                if(!visited[newX][newY] && maps[newX][newY] != 0) {
                    maps[newX][newY] += maps[x][y];
                    visited[newX][newY] = true;
                    queue.add(new Position(newX, newY));
                }
            }
        }
        return -1;
}
        
    
    
    public int solution(int[][] maps) {

        // 가로 (y)
        col = maps[0].length;
        
        // 세로 (x)
        row = maps.length;
        
        visited = new boolean[row][col];
        
        int answer = bfs(new Position(0, 0), maps);
        
        if (answer == 0) return -1;
        return answer;
    }
}