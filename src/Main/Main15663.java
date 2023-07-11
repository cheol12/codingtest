package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15663 {
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

        int before = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(before == arr[i]) continue;
            before = arr[i];    // 다음을 대비해 before 변수 갱신
            visited[i] = true;
            print[th] = arr[i];
            DFS(th + 1);
            visited[i] = false;
        }
    }
}
//https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-15663%EB%B2%88-N%EA%B3%BC-M-9-java