package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15664 {

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
        print = new int[M+1];
        visited = new boolean[N+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);
        DFS(1);
        bw.close();
    }

    static void DFS(int th)throws IOException{
        if(th == M+1){
            for(int i=1; i<=M; i++){
                bw.write(print[i] + " ");
            }
            bw.write("\n");
            return;
        }

        int before = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(before == arr[i]) continue;
            if(arr[i] < print[th-1]) continue;
            visited[i] = true;
            before = arr[i];
            print[th] = arr[i];
            DFS(th+1);
            visited[i] = false;
        }
    }
}
