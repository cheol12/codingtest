package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15657 {

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

        // 1번째로 어떤 수를 출력할 지.. 시작
        DFS(1);
        bw.close();
    }

    static void DFS(int th)throws IOException{
        if(th == M + 1){
            for(int i=1; i<=M; i++){
                bw.write(print[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(print[th - 1] > arr[i]) continue;
            print[th] = arr[i];
            DFS(th + 1);
        }
    }
}
