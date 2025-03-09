import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e:edge) { // 양방향 그래프
            int a = e[0] - 1;
            int b = e[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] dist = new int[n]; // 0번 노드로부터의 거리
        Arrays.fill(dist, -1); // 방문하지 않은 노드는 -1로 초기화

        Queue<Integer> q = new LinkedList<>();
        q.offer(0); // 0번 노드부터 시작
        dist[0] = 0; // 0번 노드로부터의 거리는 0

        while(!q.isEmpty()) { // BFS
            int x = q.poll(); // 현재 노드
            for (int y:graph.get(x)) { // 현재 노드와 연결된 노드들
                if (dist[y] == -1) { // 방문하지 않은 노드라면
                    dist[y] = dist[x] + 1; // 거리 갱신
                    q.offer(y); // 큐에 추가
                }
            }
        }

        int max = 0; // 최대 거리

        for (int i = 1; i < dist.length; i++) { // 최대 거리 구하기
            if (dist[i] > max) { // 최대 거리 갱신
                max = dist[i];
                answer = 1;
            } else if (dist[i] == max) { // 최대 거리와 같은 거리의 노드가 있으면
                answer++;
            }
        }

        return answer;
    }
}