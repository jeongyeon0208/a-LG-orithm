import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[1]부터 dp[8]까지, N을 i번 사용하여 만들 수 있는 숫자 집합

        int answer = 0;

        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i < 9; i++) { // i번 사용했을 때 단순 연결로 만들 수 있는 수
            String str = "";
            for (int j = 0; j < i; j++) {
                str += N;
            }
            dp.get(i).add(Integer.parseInt(str));
        }

        for (int i = 1; i < 9; i++) {

            if (dp.get(i).contains(number)) {
                answer = i;
                return answer;
            }

            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) { // i - j번 사용했을 때 단순 연결로 만들 수 있는 수
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if (y != 0) {
                            dp.get(i).add(x / y);
                        }
                    }
                }
                if (dp.get(i).contains(number)) {
                    answer = i;
                    return answer;
                }
            }
        }

        return -1;
    }
}