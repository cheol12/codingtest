package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main11725_kb {
    static boolean[] visited;
    static int[] parents;
    static ArrayList<Integer>[] arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());
        arrList = new ArrayList[N+1];
        // parents[2]에 인덱스 2의 부모를 저장
        parents = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            arrList[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arrList[start].add(end);
            arrList[end].add(start);
        }

        DFS(1);

        for(int i=2; i<=N; i++)
            bw.write(parents[i] + "\n");
        bw.close();
    }

    static void DFS(int nowNode){
        visited[nowNode] = true;

        // arrList[nowNode] 에 연결되어있는 간선들이
        // nowNode를 부모로 하고 있는지 판단
        for(int nextNode : arrList[nowNode]){
            if(visited[nextNode]) continue;
            parents[nextNode] = nowNode;
            DFS(nextNode);
        }
    }
}
