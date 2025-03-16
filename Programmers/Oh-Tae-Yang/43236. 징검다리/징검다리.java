import java.util.*;

class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);  // 돌을 거리 순으로 정렬
        int left = 1, right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int removed = removeRock(rocks, distance, mid);

            if (removed <= n) {
                answer = mid;
                left = mid + 1;  // 거리 증가 (더 긴 거리도 가능성 확인)
            } else {
                right = mid - 1; // 거리 감소 (더 작은 거리로 탐색)
            }
        }

        return answer;
    }

    private static int removeRock(int[] rocks, int distance, int mid) {
        int removed = 0;
        int prev = 0;  // 시작점

        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - prev < mid) {
                removed++; // 현재 돌을 제거
            } else {
                prev = rocks[i]; // 유지되는 경우 prev 업데이트
            }
        }

        // 마지막 도착점과의 거리 체크
        if (distance - prev < mid) removed++;

        return removed;
    }
}
