package Main;

import jdk.jfr.Unsigned;

import java.io.*;
import java.util.*;

class Main7562{
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int T;   // 테스트 케이스 개수
    static int I;   // 체스판 한 변의 길이
    static int[][] board;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static Queue<Point> q;
    static int startx, starty, endx, endy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];
            q = new LinkedList<>();

            token = new StringTokenizer(br.readLine());
            startx = Integer.parseInt(token.nextToken());
            starty = Integer.parseInt(token.nextToken());
            q.offer(new Point(startx, starty));

            token = new StringTokenizer(br.readLine());
            endx = Integer.parseInt(token.nextToken());
            endy = Integer.parseInt(token.nextToken());

            bfs();

            bw.write(board[endx][endy]+"\n");
        }
        bw.close();
    }

    static void bfs(){

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == endx && now.y == endy) return;

            for(int i=0; i<8; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= I || ny < 0 || ny >= I)
                    continue;
                if((board[nx][ny] == 0)){
                    q.offer(new Point(nx, ny));
                    board[nx][ny] = board[now.x][now.y] + 1;
                }
            }
        }
    }
}