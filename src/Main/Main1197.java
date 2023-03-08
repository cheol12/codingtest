package Main;

import java.io.*;
import java.util.*;

public class Main1197 {
    // 그래프 이론
    // 최소 스패닝 트리
    static class Edge {
        int s, e, cost;
        Edge(int s, int e, int cost){
            this.s = s;         // 출발노드
            this.e = e;         // 도착노드
            this.cost = cost;   // 간선의 가중치
        }
    }
    static int V, E;
    static int[] parent;

    public static void main(String args[]) throws IOException{
        //최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는
        //부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
        //
        //참고) N-1보다 적은 간선 선택시, 그래프 내의 모든 노드를 연결 불가,
        //     N-1보다 많은 간선 선택시, 사이클이 형성되어 트리 구조가 아니게 됨
        //따라서 최소 신장 트리를 구하기 위해서는 N-1개의 간선을 선택하는 것은 필수.
        //
        //입력 : 첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수
        //E(1 ≤ E ≤ 100,000)가 주어진다. 다음 E개의 줄에는 각 간선에 대한
        //정보를 나타내는 세 정수 A,B,C가 주어짐. 이는 A번 정점과 B번 정점이
        //가중치 C인 간선으로 연결되어 있다는 의미.
        //C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
        //
        //그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점
        //사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다
        //크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.
        //
        //출력 : 첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        V = Integer.parseInt(token.nextToken());    // 노드 개수
        E = Integer.parseInt(token.nextToken());    // 간선 개수

        ArrayList<Edge> edges = new ArrayList<>();
        int answer = 0; // 최종적으로 출력할 최소 스패닝 트리의 가중치

        for(int i=1; i<=E; i++){
            token = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(token.nextToken());    // 출발노드
            int B = Integer.parseInt(token.nextToken());    // 도착노드
            int C = Integer.parseInt(token.nextToken());    // 간선 가중치
            // ArrayList 객체인 edges에 각 간선 정보(출발노드, 도착노드, 간선 가중치) 입력
            edges.add(new Edge(A, B, C));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost,o2.cost);
            }
        }); // 가중치를 오름차순 기준으로 간선의 정보가 담긴 edges객체 정렬.

        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;  // 대표 노드 저장
        }

        for(int i=0; i<E; i++){
            Edge edge = edges.get(i);   // 작성해놓은 Edge클래스 객체인 edge에 간선 정보 입력.
            if(!isSameParent(edge.s, edge.e)){  // s,e 서로의 대표노드가 같지 않으면
                union(edge.s, edge.e);  // s와 e를 연결
                answer += edge.cost;    // 해당 간선의 가중치를 더한다.
            }
        }
        bw.write(answer+"\n");
        bw.close();
    }

    static int find(int x){  // index=value 일 때까지 반복=대표노드
        if(parent[x] == x){
            return x;   // 최상위 노드가 자신일 때 자신을 리턴하며 멈추기.
        }else{
            return parent[x] = find(parent[x]); // 재귀 부분(본 함수가 성립할 때까지 반복)
        }
    }
    static boolean isSameParent(int x, int y){
        x = find(x);    // x의 대표노드
        y = find(y);    // y의 대표노드
        if(x == y){     // x와 y가 같다면
            return true;    // 같은 대표 노드
        }else{
            return false;
        }

    }
    // union 연산 : x,y의 각 대표 노드가 다르다면 x,y를 연결하는 연산
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){  // x,y의 각 대표노드가 같지 않다면
            parent[y] = x;  // x는 y와 연결.
        }
        // x와 y의 대표 노드가 다를 때만 a와 b를 연결
        // x와 y의 대표 노드가 같다면 사이클이 만들어져서 가중치의 합이 최소가 될 수 없다.
    }
}

//https://st-lab.tistory.com/243
//https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-1197-%EC%B5%9C%EC%86%8C-%EC%8A%A4%ED%8C%A8%EB%8B%9D-%ED%8A%B8%EB%A6%AC-java