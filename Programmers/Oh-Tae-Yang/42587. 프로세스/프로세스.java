import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        //우선순위대로 큐에 삽입 -> PriorityQueue 이용, 숫자가 클수록 높기 때문에 Comparator.reverseOrder()로 지정
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // queue에서 순서대로 꺼내서 값이 같은지 확인 
                if (queue.peek() == priorities[i]) { 
                    //찾고자 하는 위치인지 확인
                    if (location == i) {
                        return answer;
                    }
                    //찾고자 하는 값이 아닌 경우 answer을 증가시키고 다음 데이터를 확인
                    answer++;
                    queue.poll();
                }
            }
        }
        return answer;
    }
}