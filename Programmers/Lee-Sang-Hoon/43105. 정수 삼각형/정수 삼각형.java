// bottom-up 방식으로 풀이
// 맨 아래부터 위로 올라가면서 최대값을 구해나가는 방식

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length; // 삼각형의 높이

        for(int i = n-2; i >= 0; i--) { // 맨 아래부터 위로 올라가면서 최대값을 구해나가는 방식
            for(int j = 0; j < triangle[i].length; j++) { // 각 층의 원소들을 순회하면서
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); // 현재 원소에 그 아래층의 두 원소 중 큰 값을 더해줌
            }
        }

        answer = triangle[0][0]; // 맨 위의 원소가 최대값이 됨

        return answer;
    }
}