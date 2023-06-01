package Main;

import java.util.*;
import java.io.*;

public class Main1012 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T, N, M, K;
    static int[][] cabbage;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            cabbage = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++){
                token = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                cabbage[x][y] = 1;
            }

            int count = 0;

            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    // 1인데 방문하지 않은 곳이 있으면
                    if(cabbage[j][k] == 1 && !visited[j][k]){
                        // 근처 구역을 다 방문 처리하면서 count 증가
                        bfs(j,k);
                        count++;
                    }
                }
            }

            bw.write(count+"\n");
        }

        bw.close();
    }

    static void bfs(int a, int b){

        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(a, b));
        visited[a][b] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(cabbage[nx][ny] == 1 && !visited[nx][ny]){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }
}
//https://lotuus.tistory.com/98