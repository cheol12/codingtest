package Main;

import java.io.*;
import java.util.*;

class Main1182{
    static int N,S;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        arr = new int[N];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        DFS(0,0);

        bw.write(answer + "");
        bw.close();
    }

    static void DFS(int i, int cnt){
        if(i == N) return;
        else{
            if(arr[i] + cnt == S) answer++;
            DFS(i+1, cnt);              // 지금거 넘어가기
            DFS(i+1, cnt + arr[i]); // 지금거 더하기
        }
    }
}
//https://we1cometomeanings.tistory.com/266