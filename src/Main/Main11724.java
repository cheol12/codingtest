package Main;

import java.io.*;
import java.util.*;

public class Main11724 {
    // 문제 제목 : 연결 요소의 개수
    // 알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

    static boolean visited[];   // 방문 기록 저장 배열
    static ArrayList<Integer>[] A;  // 인접 리스트의 각 ArrayList
    public static void main(String args[]) throws IOException{
        // 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

        // 입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에
        //       간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
        // 출력 : 첫째 줄에 연결 요소의 개수를 출력한다. ( = 만들어진 그래프가 몇 묶음인지 )

        // 하루코딩 : 연결 요소 = DFS가 탐색한 모든 노드의 집합
        //          연결 요소 개수 = DFS 탐색 횟수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        // 0번 인덱스 안 쓰기 때문에 N+1하는 것이다
        visited = new boolean[N+1]; // 방문 기록 저장 배열
        A = new ArrayList[N+1]; //그래프 데이터 저장 인접 리스트

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<Integer>();    // 인접 리스트의 각 ArrayList 초기화.
        }

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(token.nextToken());
            int e = Integer.parseInt(token.nextToken());
            A[s].add(e);    // 인접리스트 s에서 e로
            A[e].add(s);    // e에서 s로도 가능
        }
        // => 각 노드가 연결된 노드를 나타내는 인접리스트를 ArrayList형태로 모두 생성

        int count = 0;
        for(int i=1; i<N+1; i++){   // 시작점 i = 1 로 설정.
            if(!visited[i]){    // 현재 노드가 방문하지 않은 노드라면
                count++;        // count++
                DFS(i);         // DFS(i) 실행
            }
            // i=1 일 때, 다 수행했다면 visited[] = T T F F T F 가 된다
            // 시작 노드인 1을 true로 만들고, 1과 연결된 노드인 2와 5를 true로 만들었기 때문
            // i=6까지 반복하며 visited[] 방문 배열을 매번 업데이트한다.
        }
        bw.write(String.valueOf(count));
        bw.close();

    }
    private static void DFS(int v) { // 재귀함수 생성.
                                     // 위의 for문에서 반복하는 i = v
        if (visited[v]) {
            return;     // true면 생략
        } else {
            visited[v] = true;  // 처음 방문했으니 A[1]을 true로 설정.

            for (int i : A[v]) {  // A[1]이라면 A[1]의 모든 요소에 대하여. A[1]=2,5라면 i=2일때, i=5일때
                if (!visited[i]) {    // 현재 노드(visited[2] or visited[5])가 방문하지 않은 노드라면
                    DFS(i);
                }
            }
        }
    }
}
