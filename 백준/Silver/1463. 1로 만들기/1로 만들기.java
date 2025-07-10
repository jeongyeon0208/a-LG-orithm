import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean visited[];

    static Queue<Integer> q = new LinkedList<>();

    static void bfs(int n){

        q.offer(n);

        while(!q.isEmpty()){

            int m = q.poll();
            if(m==1) return;
            visited[m] = true;

            if(m%3 == 0 && !visited[m/3]) {
                    arr[m/3] = arr[m] + 1;
                    visited[m/3] = true;
                    q.add(m/3);
                
            }

            if(m%2 == 0 && !visited[m/2]) {
                    arr[m/2] = arr[m] + 1;
                    visited[m/2] = true;
                    q.add(m/2);
                
            }
            
            if(m -1 > 0 && !visited[m-1]) {
                    arr[m-1] = arr[m] + 1;
                    visited[m-1] = true;
                    q.add(m-1);
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        visited = new boolean[n+1];

        bfs(n);

        bw.write(String.valueOf(arr[1]));
        bw.flush();
        bw.close();
    }
}