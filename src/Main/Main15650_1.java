package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Main15650_1 {
    static int N,M;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[M+1];   // 길이가 M인 출력할 배열
        visited = new boolean[N+1];   // 중복 표시할 방문 배열

        DFS(1);
        bw.close();
    }
    static void DFS(int i) throws IOException{
        if(i == M+1){
            for(int j=1; j<=M; j++){
                bw.write(arr[j]+" ");
            }
            bw.write("\n");
            return;
        }

        // 방문하지 않았다면
        for(int j=1; j<=N; j++){
            if(!visited[j] && (arr[i-1] < j)){
                visited[j] = true;
                arr[i] = j;
                DFS(i+1);
                visited[j] = false;
            }

        }
    }
}
