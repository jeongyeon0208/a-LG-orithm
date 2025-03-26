import java.util.*;

class Solution {
    /*
    1. 노드의 개수 n은 2 이상 20,000 이하입니다.
    2. 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
    3. vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
    4. 최단 거리를 찾는 문제이므로 BFS가 적합해보인다.
    5. 각 노드의 최단 거리를 모두 찾아서 배열에 저장한다.
    6. 가장 먼 거리를 찾고 저장해 높은 배열을 순회하며 답을 찾는다.
    */
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>()); //그래프 초기화

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        dist[1] = 0;

        Queue<Integer> queue =new LinkedList<>();
        queue.offer(1);

        int max = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    max = Math.max(max, dist[next]);
                    queue.offer(next);
                }
            }
        }

        int cnt = 0;
        for (int d : dist) {
            if (d == max) {
                cnt++;
            }
        }

        return cnt;
    }
}