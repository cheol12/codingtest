package Main;

import java.io.*;
import java.util.*;

public class Main1916 {
    static class Node implements Comparable<Node>{
        int end;    // 끝 점
        int value; // 가중치

        Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        public int compareTo(Node o){
            return value - o.value;
        }
    }

    static int N, M;   // N : 도시=노드 , M : 버스=간선
    static ArrayList<Node>[] list;  // 인접리스트로 그래프 표현
    static boolean[] visited;   // 방문 확인
    // 시작점이 어딘지 설정하고 시작점에서 해당 인덱스에
    // 해당하는 끝점까지의 최단거리를 저장하는 배열
    static int[] dist;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<Node>();
        }

        // 주어진 그래프의 간선들을 인접리스트 자료구조에 넣는다
        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(token.nextToken());

            list[start].add(new Node(end, value));
        }


        // 1번(시작) 노드에서 방문 처리하고 다음 노드를 탐색한다.
        // 다음 노드 방문 처리하고
        // 다음 노드가 5번(끝) 노드가 아니라면

        token = new StringTokenizer(br.readLine());
        int startcity = Integer.parseInt(token.nextToken());
        int endcity = Integer.parseInt(token.nextToken());

        
        int result = dijkstra(startcity, endcity);

        bw.write(result+"");
        bw.close();
    }

    static int dijkstra(int start, int end){
        // 인자로 들어온 start 객체를 기준으로 두고,
        // start에서 갈 수 있는 끝 점과 그의 가중치를 입력할
        // 우선순위 큐 생성
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        // 초기값으로 시작점과 끝점이 동일한 가중치 0의 간선 정보 입력.
        pq.offer(new Node(start, 0));
        dist[start] = 0;    // 시작점으로 정한 start에서 start까지 가는 최단 거리 = 0

        while(!pq.isEmpty()){
            Node nownode = pq.poll();
            int now = nownode.end;

            if(!visited[now]){
                visited[now] = true;
                for(Node n : list[now]){
                    //
                    if(dist[n.end] > dist[now] + n.value){
                        dist[n.end] = dist[now] + n.value;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
//https://steady-coding.tistory.com/84
//https://github.com/doitcodingtest/java/blob/main/%EA%B7%B8%EB%9E%98%ED%94%84/P1916_%EC%B5%9C%EC%86%8C%EB%B9%84%EC%9A%A9%EA%B5%AC%ED%95%98%EA%B8%B0.java