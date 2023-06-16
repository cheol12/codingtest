package Main;

import java.io.*;
import java.util.*;

class Main5014{
    static int[] dx = {-1, 1};
    static int F;   // 꼭대기 층
    static int S;   // 강호 출발 층
    static int G;   // 강호 도착 층
    static int U;   // 올라가는 값
    static int D;   // 내려가는 값
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        F = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        G = Integer.parseInt(token.nextToken());
        U = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());
        building = new int[F+1];

        //층 방문 할 때마다 카운트 세기

        if(bfs()) bw.write(building[G]-1+"");
        else bw.write("use the stairs");
        bw.close();
    }

    static boolean bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        building[S] = 1;
        //처음에는 building[S] = 0;로 하다가 오류남.
        // 이유 : 밑에 while문 진행 중
        // if(building[next] == 0) 문장에서 next == S라면
        // 처음 위치라 방문한 것이지만 값을 다시 갱신하게 됨.

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == G) return true;
            for(int i=0; i<2; i++){
                int next;
                if(i == 0) next = now + dx[i]*D;
                else next = now + dx[i]*U;

                if(next < 1 || next > F) continue;
                if(building[next] == 0){
                    q.offer(next);
                    building[next] = building[now] + 1;

                }
            }
        }
        return false;
    }
}