import java.util.*;

class Solution {
    
    private static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        
        int n = words.length;
        boolean[] visited = new boolean[n];
        
        // 애초에 words 내에 target이 있는지 확인 후, 없다면 함수 호출
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        } else {
            dfs(0, begin, target, visited, words);   
        }
        
        // 함수 돌아도 answer가 최대값이면 못 찾은 것이므로 0
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void dfs(int depth, String begin, String target, boolean[] visited, String[] words) {
        if(begin.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        // 방문한 words가 아니고, 조건에 부합하면 다시 재귀 호출
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && checkOnlyOneDiff(begin, words[i])) {
                visited[i] = true;
                dfs(depth + 1, words[i], target, visited, words);
                visited[i] = false;
            }
        }
    }
    
    // 바꾸고 싶은 단어와 바꿀 단어 비교. 차이가 1보다 커지면 바로 false 리턴. 그 외엔 true 리턴.
    // 만약 diff가 0이면 그 다음 재귀 호출 때 조건에 걸림.
    private boolean checkOnlyOneDiff(String originWord, String changeWord) {
        int diff = 0;
        
        for(int i = 0; i < originWord.length(); i++) {
            if(originWord.charAt(i) != changeWord.charAt(i)) {
                diff++;
            }
            
            if(diff > 1) {
                return false;
            }
        }
        
        return true;
    }
}