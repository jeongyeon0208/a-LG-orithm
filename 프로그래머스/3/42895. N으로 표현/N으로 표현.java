import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) return 1; //N이 number와 같은 경우
        
        List<Set<Integer>> dp = new ArrayList<>(); //메모제이션을 위한 List
        
        for(int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }
        
        for(int i=1; i<=8; i++) {
            int repeatNum = Integer.parseInt(String.valueOf(N).repeat(i)); //N을 연속으로 사용하는 경우
            dp.get(i).add(repeatNum);
            
            //j + (i - j) 계산
            for(int j=1; j<i; j++) {
                for(int num1 : dp.get(j)) {
                    for(int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2); //덧셈
                        dp.get(i).add(num1 - num2); //뺄셈
                        dp.get(i).add(num1 * num2); //곱셈
                        if(num2 != 0) dp.get(i).add(num1 / num2); //나눗셈
                    }
                }
            }
            
            if(dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}