import java.util.*;

class Solution {
    
    static long calculate(Long num1, Long num2, String cal){
        switch(cal){
            case "*":
                return num1 * num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
        }
        return 0;
    }
    
    static long makeMax(List<Long> num, List<String> cal,
                          String cal1, String cal2, String cal3, Long answer){
        
        List<Long> newNum = new ArrayList<>();
        List<String> newCal = new ArrayList<>();
        for(Long n : num) newNum.add(n);
        for(String s : cal) newCal.add(s);
        
        int idx = 0;
        Long total = 0L;
        while(!newCal.isEmpty()){
            // 첫번째 기호가 있으면 index를 찾고 list에서는 삭제
            if(newCal.indexOf(cal1) != -1){
                idx = newCal.indexOf(cal1);
                newCal.remove(cal1);
                // 첫번째 기호로 계산할 숫자 2개 list에서 삭제
                Long num1 = newNum.remove(idx);
                Long num2 = newNum.remove(idx);
                Long sum = calculate(num1, num2, cal1);
                // 계산한 숫자 list에 추가
                newNum.add(idx, sum);
            }
            else if (newCal.indexOf(cal2) != -1){
                idx = newCal.indexOf(cal2);
                newCal.remove(cal2);
                Long num1 = newNum.remove(idx);
                Long num2 = newNum.remove(idx);
                Long sum = calculate(num1, num2, cal2);
                
                newNum.add(idx, sum);
            }
            else {
                idx = newCal.indexOf(cal3);
                newCal.remove(cal3);
                Long num1 = newNum.remove(idx);
                Long num2 = newNum.remove(idx);
                Long sum = calculate(num1, num2, cal3);
                
                newNum.add(idx, sum);
            }
        }
        
        return Math.max(answer, Math.abs(newNum.get(idx)));
    }
    
    public long solution(String expression) {
        long answer = 0;
        
        List<Long> num = new ArrayList<>();
        List<String> cal = new ArrayList<>();
        
        int idx = 0;
        for(int i = 0; i < expression.length(); i++){
            switch(expression.charAt(i)){
                case '+':
                    cal.add("+");
                    num.add(Long.parseLong(expression.substring(idx, i)));
                    idx = i+1;
                    break;
                case '-':
                    cal.add("-");
                    num.add(Long.parseLong(expression.substring(idx, i)));
                    idx = i+1;
                    break;
                case '*':
                    cal.add("*");
                    num.add(Long.parseLong(expression.substring(idx, i)));
                    idx = i+1;
                    break;
            }
        }
        num.add(Long.parseLong(expression.substring(idx, expression.length())));
        
        answer = makeMax(num, cal, "*", "+", "-", answer);
        answer = makeMax(num, cal, "*", "-", "+", answer);
        answer = makeMax(num, cal, "+", "*", "-", answer);
        answer = makeMax(num, cal, "+", "-", "*", answer);
        answer = makeMax(num, cal, "-", "+", "*", answer);
        answer = makeMax(num, cal, "-", "*", "+", answer);
        
        System.out.println(num);
        
        
        
        return answer;
    }
}