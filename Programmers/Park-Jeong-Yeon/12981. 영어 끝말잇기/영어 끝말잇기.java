import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        
        int len = words.length;
        int index = 1;
        set.add(words[0]);
        
        while(index < len){
            // 만약 해당 단어를 말한적이 있거나 끝말잇기 규칙 벗어나면 이놈이 정답
            String temp = words[index];
            String before = words[index-1];
        
            if(set.contains(temp) || before.charAt(before.length()-1) != temp.charAt(0)) {
                answer[0] = index%n + 1;
                answer[1] = index/n + 1;
                return answer;
            }
            else {
                set.add(temp);
                index++;
            }
        }
        
        return answer;
    }
}