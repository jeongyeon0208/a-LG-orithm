import java.util.*;

class Solution {
    static long sum1 = 0;
    static long sum2 = 0;
    
    public static int solution(int[] queue1, int[] queue2) {
        //Queue1 세팅
        Queue<Long> q1 = new LinkedList<>();
        for (long num : queue1) {
            q1.offer(num);
            sum1 += num;
        }

        //Queue2 세팅
        Queue<Long> q2 = new LinkedList<>();
        for (long num : queue2) {
            q2.offer(num);
            sum2 += num;
        }

        int cnt = 0;
        int maxCnt = (queue1.length + queue2.length) * 2;

        while(cnt <= maxCnt) {
            if (sum1 == sum2) {
                return cnt;
            } else {
                if (sum1 > sum2) {
                    Long num = q1.poll();
                    sum1 -= num;
                    sum2 += num;
                    q2.offer(num);
                } else {
                    Long num = q2.poll();
                    sum2 -= num;
                    sum1 += num;
                    q1.offer(num);
                }
            }
            cnt++;
        }
        return -1;
    }
}