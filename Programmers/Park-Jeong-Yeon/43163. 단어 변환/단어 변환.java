import java.util.*;

class Node{
    int index;
    String word;
    public Node(int index, String word){
        this.index = index;
        this.word = word;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        // 단어의 개수
        int size = words.length;
        
        // 닥 단어의 길이
        int wordLength = words[0].length();
        
        boolean[] visited = new boolean[size];
        int[] countArr = new int[size];
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, begin));
        
        while(!queue.isEmpty()){
            Node tempNode = queue.remove();
            int index = tempNode.index;
            String temp = tempNode.word;
            
            // words를 돌면서 1개 차이나는거 큐에 넣기
            for(int i = 0; i < size; i++){
                if(visited[i]) continue;
                
                int count = 0;
                // 단어 길이 만큼 for문으로 몇개 차이나는지 확인
                for(int k = 0; k < wordLength; k++){
                    if(temp.charAt(k) != words[i].charAt(k)) count++;
                }
                // 1개만 차이나고 방문한 적 없는 단어면 큐에 넣는다
                if(count == 1 && !visited[i]) {
                    queue.offer(new Node(i ,words[i]));
                    visited[i] = true;
                    countArr[i] = countArr[index] + 1;
                    // 넣은 단어가 타겟이라면 return
                    if(words[i].equals(target)) return countArr[i];
                }
            }
        }
        
        
        return 0;
    }
}