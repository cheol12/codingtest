package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15654 {

    static int N,M;
    static int[] arr;
    static int[] print;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N+1];
        visited = new boolean[N+1];
        print = new int[M];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);
        DFS(0);

        bw.close();
    }

    // th => th번째로 출력할 숫자 == print[th] 라는 의미
    static void DFS(int th) throws IOException{
        if(th == M){
            for(int i=0; i<M; i++){
                bw.write(print[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            print[th] = arr[i];
            DFS(th + 1);    // 다음으로 출력할 숫자를 arr에서 고르는 DFS.
            visited[i] = false;
        }
    }
}
