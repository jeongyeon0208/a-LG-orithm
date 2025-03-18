import java.util.*;

class Solution {
    // 각 단계와 실패율을 저장할 구조체
    static class KV implements Comparable<KV>{
        int key;
        double value;
        
        public KV(int k, double v){
            this.key = k;
            this.value = v;
        }
        
        @Override
        public int compareTo(KV o) {
             int valueCompare = Double.compare(o.value, this.value); // value가 큰 순서대로
             if (valueCompare == 0) {
                 return Integer.compare(this.key, o.key); // key가 작은 순서대로
             }
            return valueCompare;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        // 각 단계별 실패율을 저장할 배열
        double[] arr = new double[N];
        
        // 사람 수
        int len = stages.length;
        
        List<KV> list = new ArrayList<>();
        
        Arrays.sort(stages);
        
        // 방문했는지 확인할 변수
        int checkStage = 0;
        
        // 전체 사람을 보며 실패율 계산
        for(int i = 0; i < len; i++){
            int tempStage = stages[i];
            
            // 이미 확인한 단계거나 N단계보다 큰 경우 continue
            if(checkStage == tempStage || tempStage > N) continue;
            else checkStage = tempStage;
                
            // 기본적으로 자기의 단계는 실패했으므로 1로 시작
            int fail = 1;
            
            // 다음 인덱스부터 돌면서 자기랑 같으면 실패 인원 증가
            for(int j = i+1; j < len; j++){
                if(tempStage == stages[j]) fail++;
                else break;
            }
            
            // 총 단계 도달 인원은 전체인원 - 현재 본인의 인덱스 (정렬돼있으므로)
            double percent = (double)fail/(double)(len - i);
            arr[tempStage-1] = percent;
        }
        
        // 각 단계와 실패율을 리스트에 넣고 정렬
        for(int i = 0; i < N; i++) list.add(new KV(i+1, arr[i]));
        Collections.sort(list);
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = list.get(i).key;
        }
        
        return answer;
    }
}