//linked list를 활용한 큐를 사용하여 BFS로 최단 거리 탐색

import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int answer = -1;

        // maps의 크기
        int n = maps.length;
        int m = maps[0].length;

        //BFS를 위한 큐
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); //시작점 0,0과 이동 거리 1

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            //상하좌우 이동
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위를 벗어나면 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //벽이면 무시
                if(maps[nx][ny] == 0) continue;

                //도착지점에 도달하면 이동거리 반환
                if(nx == n-1 && ny == m-1) {
                    answer = dist + 1; 
                }

                //이동한 칸을 0으로 바꾸어 다시 방문하지 않도록 함
                maps[nx][ny] = 0;
                q.offer(new int[]{nx, ny, dist+1});
            }
        }

        return answer;
    }
}