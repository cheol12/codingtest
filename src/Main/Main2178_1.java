package Main;

import java.io.*;
import java.util.*;

class Main2178_1 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;   // 미로판
    static boolean[][] visited;
    static int N;   // 세로
    static int M;   // 가로
    static int[] dx = {-1, 0, 1, 0};    // 좌 하 우 상
    static int[] dy = {0, 1, 0, -1};    // 좌 하 우 상
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }

        bfs(0, 0);

        bw.write(board[N-1][M-1] + "");
        bw.close();
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while(!q.isEmpty()){
            Point point = q.poll();


            // 4방향 판단
            for(int k=0; k<4; k++){
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
                board[nx][ny] = board[point.x][point.y] + 1;
            }
        }
    }
}
//https://wiselog.tistory.com/163