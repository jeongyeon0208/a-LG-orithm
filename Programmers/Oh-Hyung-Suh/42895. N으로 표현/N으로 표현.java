import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number){
            return 1;
        }
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        }
        
        dp.get(1).add(N);
        
        for(int i = 2; i < 9; i++) {
            
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for(int j = 1; j < i; j++) {
                int k = i - j;
                
                for(int n : dp.get(j)) {
                    for(int m : dp.get(k)) {
                        dp.get(i).add(n + m);
                        dp.get(i).add(n - m);
                        dp.get(i).add(n * m);
                        
                        if(m != 0) {
                            dp.get(i).add(n / m);
                        }
                    }
                }
            }
            
            if(dp.get(i).contains(number)) {
                return i;
            }
        }
    
        return -1;
    }
}