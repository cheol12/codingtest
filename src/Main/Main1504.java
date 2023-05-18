package Main;

import java.io.*;
import java.util.*;

class Main1504 {
    static class Node implements Comparable<Node>{
        int end;
        int value;
        Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        public int compareTo(Node o){
            return value - o.value;
        }
    }

    static int N, E;    //정점=노드, 간선=엣지
    static ArrayList<Node>[] list;  // 인접리스트로 그래프 표현
    static int[] dist;  // 최단거리
    static boolean[] visited;   // 방문처리
    static int INF = 200000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());

        list = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=E; i++){
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        token = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(token.nextToken());
        int v2 = Integer.parseInt(token.nextToken());

        // 1 -> v1 -> v2 -> N 으로 최단 거리 이동하는 경우
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N 으로 최단 거리 이동하는 경우
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int result = Math.min(result1, result2);

        // INF 대신 Integer.MAX_VALUE 로 하면 오답
        if(result >= INF) bw.write("-1");
        else bw.write(result+"");
        bw.close();
    }

    static int dijkstra(int start, int end){
        // INF 대신 Integer.MAX_VALUE 로 하면 오답
        Arrays.fill(dist, INF);
        visited = new boolean[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node nownode = pq.poll();
            int now = nownode.end;

            if(!visited[now]){
                visited[now] = true;

                for(Node n : list[now]){
                    if(!visited[n.end] && dist[n.end] > dist[now] + n.value){
                        dist[n.end] = dist[now] + n.value;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
//https://steady-coding.tistory.com/82