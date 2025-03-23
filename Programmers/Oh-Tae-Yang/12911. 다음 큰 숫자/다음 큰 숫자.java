import java.util.*;

class Solution {
    public int solution_old(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        long cnt = Arrays.stream(binary.split("")).filter( s -> s.equals("1")).count();
        while(true) {
            n++;
            if (cnt == Arrays.stream(Integer.toBinaryString(n).split("")).filter( s -> s.equals("1")).count()) {
                answer = n;
                break;
            }
        }
        return answer;
    }
    
    public int solution(int n) {
        int answer = 0;
        int n_cnt = Integer.bitCount(n);
        int b_cnt = 0;
        while(true) {
            n++;
            b_cnt = Integer.bitCount(n);
            if(n_cnt == b_cnt) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}