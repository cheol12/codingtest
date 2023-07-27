package Main;

import java.io.*;
import java.util.*;

class Main2961{
    // 부분집합 이용해서 모든 경우의 수 찾기
    static int N;
    static int[][] food;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        food = new int[N][2];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(token.nextToken());   // 신맛
            food[i][1] = Integer.parseInt(token.nextToken());   // 쓴맛
        }

        DFS(0);
        bw.write(min+"");
        bw.close();
    }

    static void DFS(int th){
        if(th == N){
            int sour = 1;
            int bitter = 0;
            int count = 0;
            for(int i=0; i<N; i++){
                if(!visited[i]) continue;
                sour *= food[i][0];
                bitter += food[i][1];
                count++;
            }

            if(count == 0) return;  // 재료를 사용하지 않았다면 그냥 종료
            int chai = Math.abs(sour - bitter);
            if(chai < min) min = chai;  // 차이를 최소값으로 갱신
            return;
        }

        // th번째 재료 사용 할때
        visited[th] = true;
        DFS(th+1);
        // th번째 재료 사용 안할때
        visited[th] = false;
        DFS(th+1);
    }
}
//https://wiselog.tistory.com/129