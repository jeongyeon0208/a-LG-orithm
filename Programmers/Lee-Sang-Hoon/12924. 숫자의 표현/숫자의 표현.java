class Solution {
    public int solution(int n) {
        int count = 0;
        // k는 연속된 수열의 길이
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            // x = (n - k*(k-1)/2) / k 가 자연수인지 확인
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
        }
        return count;
    }
}
