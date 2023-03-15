package Main;

import java.util.*;
import java.io.*;

public class Main15650 {

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

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // 출력할 수열 순서는 무조건 오름차순
        visited = new boolean[N+1];
        a = new int[M+1];

        DFS(0);

        bw.close();
    }
    static void DFS(int x) throws IOException{
        if(x == M){     // x가 M이 되면 출력
            for(int i=0; i<M; i++){
                bw.write(String.valueOf(a[i])+" ");
            }
            bw.write("\n");
            return;
        }

        // DFS(x)의 x가 1이상인데 i가 a[x-1]보다 작은 경우만 DFS못들어감.
        // 그렇지 않은 경우만 DFS실행
        // 출력할 숫자 확인
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                a[x] = i;
                if(!(x>=1 && i < a[x-1]))
                    DFS(x+1);
                visited[i] = false;
            }
        }
    }
}
