package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Main15651_1 {

    static int N,M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[M+1];

        DFS(1);

        bw.close();
    }

    static void DFS(int i) throws IOException{
        if(i == M+1){
            for(int j=1; j<=M; j++){
                bw.write(arr[j] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int j=1; j<=N; j++){
            arr[i] = j;
            DFS(i + 1);

        }
    }
}
