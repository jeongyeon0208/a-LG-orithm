import java.util.Arrays;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 1;
        int right = distance; 
        Arrays.sort(rocks); // 바위 정렬

        while (left <= right) { // 이분 탐색
            int mid = (left + right) / 2; 
            int cnt = 0; // 제거한 바위 수
            int prev = 0; // 이전 바위 위치

            for (int rock : rocks) { // 바위 사이의 거리가 mid보다 작으면 제거
                if (rock - prev < mid) {
                    cnt++;
                } else { // 아니면 이전 바위 위치 갱신
                    prev = rock;
                }
            }

            if (distance - prev < mid) { // 마지막 바위와 도착지 사이의 거리가 mid보다 작으면 제거
                cnt++;
            }

            if (cnt > n) { // 제거한 바위 수가 n보다 크면 mid를 줄여야 함
                right = mid - 1;
            } else { // 아니면 mid를 늘려야 함
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}