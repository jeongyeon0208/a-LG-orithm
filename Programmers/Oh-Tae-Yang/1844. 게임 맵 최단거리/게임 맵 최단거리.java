import java.util.*;

class Solution {
/*
BFS, DFS 모두 그래프를 탐색하는 방법, 두 노드 사이의 최단 경로를 찾고 싶은 경우 BFS를 주로 사용한다.
1. 위치한 정점에 연결된 가까운 점들부터 탐색
2. 상,하,좌,우 중 갈 수 있는 위치인지를 판단
3. 가장 먼저 도착하는 경우가 최단 거리
*/
static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; //상,하,좌,우 이동 가능한 범위
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        return bfs(maps, visited, n, m); //BFS 탐색
    }

    public static int bfs(int[][] maps, boolean[][] visited, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); //시작점: 0,0,1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == (n-1) && y == (m -1)) {
                return dist;
            }

            for (int[] direction : directions) {
                int moveX = x + direction[0];
                int moveY = y + direction[1];

                if (isValid(maps, visited, moveX, moveY, n, m)) {
                    queue.offer(new int[]{moveX, moveY, dist + 1});
                    visited[moveX][moveY] = true;
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int[][] maps, boolean[][] visited, int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && maps[x][y] == 1 && !visited[x][y];
    }
}