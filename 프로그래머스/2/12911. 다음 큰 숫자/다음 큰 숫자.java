class Solution {
    public int solution(int n) {
        int answer = n;
        // 2진수로 변환
        String str = Integer.toBinaryString(n);
        
        // 1의 개수 count
        String str1 = str.replace("0","");
        int count = str1.length();
        
        while(true){
            // 1씩 늘려가며 1의 개수 확인 후 count와 비교
            answer++;
            str = Integer.toBinaryString(answer);
            str1 = str.replace("0","");
            int count1 = str1.length();
            if(count == count1) return answer;
        }
    }
}