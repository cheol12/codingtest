package Main;

import java.util.*;
import java.io.*;

public class Main1260 {
    static int N,M,V;
    static int[][] graph;
    static boolean[] visited;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());    //
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());    // 탐색 시작점

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            graph[start][end] = graph[end][start] = 1;

        }
        dfs(V);
        bw.write("\n");
        visited = new boolean[N+1];
        bfs(V);
        bw.close();
    }

    static void dfs(int V) throws IOException{
        visited[V] = true;
        bw.write(V+" ");
        for(int i=1; i<=N; i++){
            if(graph[V][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int V) throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;
        bw.write(V + " ");

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1; i<=N; i++){
                if(graph[temp][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                    bw.write(i + " ");
                }
            }
        }
    }
}
//https://m.blog.naver.com/lm040466/221787478911