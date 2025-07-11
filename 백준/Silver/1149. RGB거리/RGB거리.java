import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] answer;

    static int dp(int index, int color){
        if(index >= n) return 0;
        if(answer[index][color] == 0){
            answer[index][color] = arr[index][color] +
                    Math.min(
                            dp(index + 1, (color+1)%3),
                            dp(index + 1, (color+2)%3)
                    );
        }

        return answer[index][color];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        answer = new int[n][3];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++){
            dp(0, i);
        }

        Arrays.sort(answer[0]);

        bw.write(answer[0][0] + "\n");
        bw.flush();
        bw.close();
    }
}