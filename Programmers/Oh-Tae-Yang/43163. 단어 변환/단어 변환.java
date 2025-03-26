import java.util.*;
/*
1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
3. 최단 경로를 묻는 것으로 BFS가 유리해보인다.
*/

class Solution {
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q1 = new LinkedList<>(); //단어를 넣을 queue
        Queue<Integer> q2 = new LinkedList<>(); //변환 횟수를 넣을 queue

        Set<String> visited = new HashSet<>(); //탐색 여부를 넣을 set

        if (!Arrays.asList(words).contains(target)) return 0;

        q1.offer(begin);
        q2.offer(0);

        while (!q1.isEmpty()) {
            String word = q1.poll();
            int cnt = q2.poll();

            if (word.equals(target)) {
                return cnt;
            }

            for (String s : words) {
                if (!visited.contains(s) && isValid(word, s)) {
                    visited.add(s);
                    q1.offer(s);
                    q2.offer(cnt + 1);
                }
            }
        }

        return 0;
    }

    public static boolean isValid(String from, String to) {
        int len = from.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (from.charAt(i) == to.charAt(i)) {
                cnt++;
            }
        }
        return cnt == len -1;
    }
}