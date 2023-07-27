package Main;

import java.io.*;
import java.util.*;

public class Main11724_2 {
    static int N,M;
    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arrayLists = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                BFS(i);
                count++;
            }
        }
        bw.write(count + "");
        bw.close();
    }

    static void BFS(int nowNode){
        Queue<Integer> q = new LinkedList<>();

        q.offer(nowNode);
        visited[nowNode] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i : arrayLists[now]){
                if(visited[i]) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}
