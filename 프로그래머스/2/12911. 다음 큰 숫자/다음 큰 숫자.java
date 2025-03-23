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

/**
 * 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
 * 2. n의 다음 큰 숫자는 n의 2진수로 변환했을 때 1의 갯수가 같습니다.
 * 3. n의 다음 큰 숫자는 조건 1,2를 만족하는 수 중 가장 작은 수 입니다.
 *
 * -------------------------------------------------------------
 * solution 1
 * java.lang.Integer의  toBinaryString(), toOctalString(), toHexaString() 메소드를 이용하여
 * 10진수를 2진수, 8진수, 16진수 문자열로 변환할 수 있습니다.
 *
 * solution 2
 * Integer.bitCount: 정수를 매개변수로 넣었을때 그 정수의 1 의 개수를 반환한다.
 */