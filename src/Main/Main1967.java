package Main;

import java.io.*;
import java.util.*;

public class Main1967 {
    // 간선의 정보를 클래스로 정의
    static class Edge implements Comparable<Edge>{
        int end;    // 이어져 있는 끝점
        int value;  // 간선의 길이
        Edge(int end, int value){
            this.end = end;
            this.value = value;
        }
        // 해당 문제는 Comparable과 함께 return하는 부분 없어도 무방
        public int compareTo(Edge o){
            return value - o.value;
        }
    }
    static int n;
    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int diameter = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];


        for(int i=1; i<=n; i++){
            // tree[i] - i를 시작점으로 하는 간선들을 입력
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            tree[start].add(new Edge(end, value));
            tree[end].add(new Edge(start, value));
        }

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            visited[i] = true;
            //dfs(node, length) => 첫 노드 ~ 끝 노드의 길이를 재기 위함
            // node = 길이 재기 시작할 노드, length = 여태까지의 길이 = 가중치의 합
            dfs(i,0);
        }
        bw.write(diameter+"");
        bw.close();
    }

    static void dfs(int node, int length){
        for(Edge edge : tree[node]){
            if(!visited[edge.end]){
                visited[edge.end] = true;
                dfs(edge.end, length + edge.value);
            }
        }
        diameter = Math.max(diameter, length);
    }
}
//https://ilmiodiario.tistory.com/148?category=914174