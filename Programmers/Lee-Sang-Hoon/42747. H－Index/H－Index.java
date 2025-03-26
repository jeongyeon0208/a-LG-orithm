import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length; // 논문의 수

        for (int i = 0; i < n; i++) { // i번째 논문의 인용 횟수가 n - i 이상인지 확인
            int h = n - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}