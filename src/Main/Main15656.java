package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15656 {

    static int N,M;
    static int[] arr;
    static int[] print;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N+1];
        print = new int[M+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr);
        DFS(0);

        bw.close();
    }

    static void DFS(int th) throws IOException{
        if(th == M){
            for(int i=0; i<M; i++){
                bw.write(print[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            print[th] = arr[i];
            DFS(th + 1);
        }

    }
}
