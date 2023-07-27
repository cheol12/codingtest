package Main;

import java.io.*;
import java.util.*;

class Main2178_kb{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] miro;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N,M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
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
                miro[i][j] = Integer.parseInt(temp.substring(j,j+1));
                // temp.charAt(j) - '0' ==> 결과 똑같음.
            }
        }

        BFS(0,0);
        bw.write(miro[N-1][M-1] + "");
        bw.close();
    }

    static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(miro[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                q.offer(new Point(nx, ny));
                miro[nx][ny] = miro[now.x][now.y] + 1;
                visited[nx][ny] = true;
            }
        }

    }
}
