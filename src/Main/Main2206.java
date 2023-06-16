package Main;

import java.io.*;
import java.util.*;

class Main2206 {
    static class Point {
        int x, y, dist, drill;

        Point(int x, int y, int dist, int drill) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.drill = drill;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;
    static int N,M;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(temp.substring(j,j+1));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        // 풀이 포인트 :
        // 1. Point 클래스를 x,y,time,drill 4개의 객체로 표현하고 drill에는 공사 횟수 입력
        // 2. visited 배열을 int형으로 생성(MAX_VALUE로 초기화)하고
        // 배열 안에 공사 횟수 입력.
        bfs();
        bw.write(result+"");
        bw.close();
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0, 1, 0));
        visited[0][0] = 0;

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == N-1 && now.y == M-1) {
                result = now.dist;
                return;
            }
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if(visited[nx][ny] <= now.drill)
                    continue;
                if(map[nx][ny] == 0){
                    visited[nx][ny] = now.drill;
                    q.offer(new Point(nx, ny, now.dist + 1, now.drill));
                }
                else{   // map[nx][ny] == 1, 벽인데 drill을 한 번도 안 뚫었으면
                    if(now.drill == 0){
                        visited[nx][ny] = now.drill + 1;
                        q.offer(new Point(nx, ny, now.dist + 1, now.drill + 1));
                    }
                }
            }
        }//while 종료
    }// bfs() 종료

}

// 처음 혼자 풀 때는 상하좌우로 이동하는 반복문 속에서
// "1칸 뒤는 1인데 2칸 뒤는 0일 때, 벽을 부순다."
// 라는 조건문을 걸며 풀어보았지만 벽을 1번만 부수고 나아간다는 조건을 생각해내지 못했다

//https://kim6394.tistory.com/201