package programmers;

import java.util.*;

class Solution네트워크 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers));
    }

    // 컴퓨터에 간접 연결된 것까지 한 번에 검사하기 때문에
    // = xy좌표 기준이 아닌 컴퓨터마다(=노드마다) 판단하기 위해 1차원 배열
    static boolean[] visited;
    static Queue<Integer> q;

    static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        // 하나의 컴퓨터에 이어져 있는, 컴퓨터들의 번호를 담는 큐
        q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(visited[i]) continue;

            bfs(visited, computers, i); // i번째 컴퓨터랑 이어져있는 네트워크 파악
            answer++; // 파악 되면 네트워크 개수 + 1
        }

        return answer;
    }

    static void bfs(boolean[] visited, int[][] computers, int i){
        // 처음 컴퓨터 번호 i
        q.offer(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int now = q.poll(); // 컴퓨터 번호 추출.

            // now번째 컴퓨터와 이어져있는 j번째 컴퓨터들을 확인.
            for(int j=0; j<computers.length; j++){
                if(visited[j]) continue;
                if(computers[now][j] == 0) continue;
                q.offer(j);
                visited[j] = true;
            }
        }
    }// 끝
}