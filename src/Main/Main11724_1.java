package Main;

import java.util.*;
import java.io.*;

class Main11724_1{
    static int[][] graph;
    static int N,M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        // 노드 간에 연결 표시(양쪽으로)
        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            graph[start][end] = graph[end][start] = 1;
        }

        // 답(=연결 요소 개수) 넣을 객체
        int result = 0;

        // 과정 설명 : 노드1 부터 방문 시작.
        // boolean 객체는 처음에 false값으로 초기화 되어있으므로
        // true로 바꾸면서 반복문 시작하기.
        // dfs 시작..
        // 모든 노드에 대해 노드1과 연결되어있는지 확인한다.
        // 노드1과 더 이상 연결된 것이 없으면 노드1을 포함하여 확인된 노드들이
        // 하나의 연결 요소. -> result += 1
        // 그 다음 노드2 부터 다시 위 과정 반복...

        // 방문 시작
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }
        }
        bw.write(result+"");
        bw.close();
    }
    static void dfs(int x){
        if(visited[x]){    // 방문한 거면 패스
            return;
        }else{    // 방문하지 않았으면
            visited[x] = true;
            for(int i=1; i<=N; i++){
                // 노드x가 노드i에 연결되어 있으면 i로 건너가서
                // i부터 다시 연결 상태 확인하는 dfs실행.
                if(graph[x][i] == 1) dfs(i);
            }
        }
    }
}