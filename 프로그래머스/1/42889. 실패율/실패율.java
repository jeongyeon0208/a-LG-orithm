import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();

        int num = 1;
        while(num <= N) {
            double a = 0;
            double b = 0;
            for (int i : stages) {
                if (i >= num) {
                    a++;
                }
                if (i == num) {
                    b++;
                }
            }
            map.put(num, a != 0 ? b/a : 0);
            num++;
        }

        //Compartor 정의(value 내림차순, key 내림차순)
        Comparator<Map.Entry<Integer, Double>> comparator =
                Map.Entry.<Integer, Double>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey());

        List < Map.Entry < Integer, Double >> list = new ArrayList<>(map.entrySet());

        list.sort(comparator);

        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Double> entry = list.get(i);
            answer[i] = list.get(i).getKey();
        }

        return answer;
    }
}