package Main;

import java.util.*;
import java.io.*;

public class Main15651 {
    static int N,M;
    static boolean[] visited;
    static int[] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        // 1부터 N까지 자연수 중에서 M개를 고른 수열 (중복 가능)
        visited = new boolean[N+1];    // 1~N까지의 자연수 : 출력 여부 확인

        // 중복 가능하기 때문에 visited로 확인할 필요가 없어짐

        a = new int[M+1];   // 출력할 자연수 넣을 배열

        DFS(0);

        bw.close();
    }

    static void DFS(int x) throws IOException{
        if(x == M){
            for(int i=0; i<M; i++){
                bw.write(String.valueOf(a[i]) + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            a[x] = i;
            DFS(x+1);
        }
    }
}
