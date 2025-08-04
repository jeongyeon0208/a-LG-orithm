import java.util.*;
import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        // 오름차순 정렬
        Collections.sort(list);

        // 최솟값은 제일 작은값 * 줄 개수
        int min = list.get(0) * n;

        for(int i = 1; i < n; i++){
            int next = list.get(i) * (n - i);
            if(next > min) {
                min = next;
            }
        }

        System.out.println(min);
    }
}