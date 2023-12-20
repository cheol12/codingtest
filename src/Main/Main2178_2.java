package Main;

import java.util.*;
import java.io.*;

public class Main2178_2{
    static class Point{
        int x,y,time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[][] miro;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> q;
    static boolean[][] visited;
    static int N, M, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        miro = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                miro[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }
        bfs();

        bw.write(answer + "");
        bw.close();
    }
    static void bfs(){
        // 초기 조건 세팅
        q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            // 탈출 조건
            if(now.x == N-1 && now.y == M-1) {
                answer = now.time;
                return;
            }

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(miro[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                q.offer(new Point(nx, ny, now.time + 1));
                visited[nx][ny] = true;
            }
        }
    }
}
