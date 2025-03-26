import java.util.*;

class Solution {
    
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    private int n;
    private int m;
    
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        maps[0][0] = 0;
        
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(0, 0, 1));
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            int x = p.x;
            int y = p.y;
            int distance = p.distance;
            
            if(x == n-1 && y == m-1) {
                return distance;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isPossible(nx, ny, maps)) {
                    q.add(new Point(nx, ny, distance + 1));
                    maps[nx][ny] = 0;
                }
            }
        }
        
        return -1;
    }
    
    private boolean isPossible(int nx, int ny, int[][] maps) {
        return (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 1);
    }
    
    public class Point {
        int x;
        int y;
        int distance;
        
        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}