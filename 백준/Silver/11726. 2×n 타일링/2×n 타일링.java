import java.io.*;

public class Main {
    static int n;
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            bw.write(1 + "\n");
            bw.flush();
            bw.close();
        }
        else if (n == 2){
            bw.write(2 + "\n");
            bw.flush();
            bw.close();
        }
        else{
        answer = new int[n+1];
        answer[1] = 1;
        answer[2] = 2;

        for(int i = 3; i <= n; i++){
            answer[i] = (answer[i-1] + answer[i-2])%10007;
        }

        bw.write(answer[n] + "\n");
        bw.flush();
        bw.close();
            
        }
    }
}