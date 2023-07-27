package Main;

import java.io.*;
import java.util.*;

class Main13023_kb {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        // 문제 뜻 : 5명이 친구관계로 이어지는 것을 찾아라
        // == 그래프상 5개의 노드가 일직선으로 이어지는 것을 찾아라
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int fr1 = Integer.parseInt(token.nextToken());
            int fr2 = Integer.parseInt(token.nextToken());
            arr[fr1].add(fr2);
            arr[fr2].add(fr1);
        }

        for(int i=0; i<N; i++){
            if(result != 0) continue;
            visited[i] = true;
            DFS(i, 1);
            visited[i] = false;
        }
        bw.write(result+"");
        bw.close();
    }

    static void DFS(int start, int th){
        if(th == 5){
            result = 1;
            return;
        }

        for(int i : arr[start]){
            if(visited[i]) continue;
            visited[i] = true;
            DFS(i, th+1);
            visited[i] = false;
        }
    }
}
//https://minhamina.tistory.com/50