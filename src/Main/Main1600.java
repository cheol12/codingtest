package Main;

import java.io.*;
import java.util.*;

class Main1600{
    static class Point{
        int x, y, move, K;
        Point(int x, int y, int move, int K){
            this.x = x;
            this.y = y;
            this.move = move;
            // 사용 가능한 말의 움직임이 K번 남았다는 것을 표현
            this.K = K;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hdx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdy = {-2, -1, 1, 2, 2, 1, -1, -2};
    // visited[][][K] == K번 남았을 경우의 방문 여부를 뜻함
    static boolean[][][] visited;
    static int[][] map;
    static int K, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        K = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i=0; i<H; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(token.nextToken());

            }
        }

        bw.write(bfs()+"");
        bw.close();
    }

    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0, 0, K));
        visited[0][0][K] = true;

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == H-1 && now.y == W-1) return now.move;
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= H || ny < 0 || ny >= W)
                    continue;
                if(visited[nx][ny][now.K] || map[nx][ny] == 1)
                    continue;
                q.offer(new Point(nx, ny, now.move + 1, now.K));
                visited[nx][ny][now.K] = true;
            }

            if(now.K <= 0) continue;
            for(int i=0; i<8; i++){
                int nhx = now.x + hdx[i];
                int nhy = now.y + hdy[i];

                if(nhx < 0 || nhx >= H || nhy < 0 || nhy >= W)
                    continue;
                if(visited[nhx][nhy][now.K - 1] || map[nhx][nhy] == 1)
                    continue;
                q.offer(new Point(nhx, nhy, now.move + 1, now.K - 1));
                visited[nhx][nhy][now.K - 1] = true;
            }
        }
        return -1;
    }
}
//https://moonsbeen.tistory.com/181