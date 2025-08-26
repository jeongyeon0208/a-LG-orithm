import java.io.*;
import java.util.*;

public class Main {

    public static class Pair implements Comparable<Pair> {
        int index;
        int value;

        public Pair(int i, int v){
            this.index = i;
            this.value = v;
        }

        @Override
        public int compareTo(Pair o) {
            // value 내림차순
            int result = Integer.compare(o.value, this.value);
            if(result != 0 ) return result;
            else return Integer.compare(this.index, o.index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pqA = new PriorityQueue<>();

        StringTokenizer stA = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            int value = Integer.parseInt(stA.nextToken());
            pqA.add(new Pair(i, value));
        }

        int b = Integer.parseInt(br.readLine());
        int[] arrB = new int[b];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
            int value = Integer.parseInt(stB.nextToken());
            arrB[i] =value;
        }

        List<Integer> answerList = new ArrayList<>();
        int start = 0;
        int lastIndex = -1;
        while(!pqA.isEmpty()){
            Pair tempA = pqA.poll();
            for(int i = start; i < b; i++){
                if(arrB[i] == tempA.value && tempA.index > lastIndex){
                    answerList.add(arrB[i]);
                    lastIndex = tempA.index;
                    start = i+1;
                    break;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for(int i : answerList){
            sb.append(i + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
