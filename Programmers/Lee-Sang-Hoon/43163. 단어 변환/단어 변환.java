import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        boolean isExist = false; // target이 words에 존재하는지 확인

        for (String word : words) { // target이 words에 존재하면 true
            if (word.equals(target)) {
                isExist = true;
                break;
            }
        }

        if (!isExist) { // target이 words에 존재하지 않으면 0 리턴
            return 0;
        }

        Queue<node> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new node(begin, 0)); // 시작 단어를 큐에 추가

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            node current = queue.poll(); // 큐에서 하나 꺼내기

            if (current.word.equals(target)) { // 현재 단어가 target이면 count 리턴
                return current.count;
            }

            for (String word : words) { // words를 순회하며 현재 단어와 한 글자만 다른 단어를 큐에 추가
                if (isPossible(current.word, word)) {
                    queue.add(new node(word, current.count + 1));
                }
            }
        }

        int answer = 0; // target에 도달할 수 없는 경우 0 리턴
        return answer;
    }

    public boolean isPossible(String current, String next) { // 한 글자만 다른지 확인
        int count = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    class node { // 단어와 count를 저장하는 클래스
        String word;
        int count;

        public node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}