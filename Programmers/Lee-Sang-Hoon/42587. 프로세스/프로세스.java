// priority queue와 queue를 이용

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>(); // 인덱스 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 저장

        for (int i = 0; i < priorities.length; i++) { // 초기화
            q.offer(i);
            pq.offer(priorities[i]);
        }

        while (!q.isEmpty()) { // 큐가 빌 때까지
            int i = q.poll(); // 인덱스
            int p = pq.peek(); // 우선순위

            if (priorities[i] == p) { // 우선순위가 가장 높은 경우
                pq.poll(); // 우선순위 큐에서 제거
                answer++;

                if (i == location) { // location인 경우
                    break;
                }
            } else { // 우선순위가 가장 높지 않은 경우
                q.offer(i);
            }
        }

        return answer;
    }
}