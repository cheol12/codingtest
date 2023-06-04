package Main;

import java.io.*;
import java.util.*;

class Main7576 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int M, N;    // M=가로, N=세로
    static int[][] board;   // 토마토 창고판
    static int[] dx = {-1, 0, 1, 0};    // 좌 하 우 상
    static int[] dy = {0, 1, 0, -1};    // 좌 하 우 상
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());    // 가로 M칸
        N = Integer.parseInt(token.nextToken());    // 세로 N칸

        board = new int[N][M];
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(token.nextToken());

                if(board[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        // 안 익은 토마토들은 board[i][j]에서 0으로 되어있다.
        // 안 익은 토마토들이 익을 때까지 며칠이 걸리는지 값을 재정의해 나간다.

        // board 에서 1을 발견하면 해당 Point를 큐에 넣는다.
        // 큐에 담겨있는 Point에서 상하좌우 이동 후 0을 발견하면
        // 이동 후 Point를 큐에 담으면서 board[이동 후] = board[이동 전]+1을 한다
        // (=안 익은 토마토가 익을 때까지 걸리는 날짜)
        // board 범위를 벗어나는 것은 패스

        // 재정의한 board 안에서 최대값을 찾는다

        bw.write(bfs()+"");
        bw.flush();
        bw.close();
    }

    static int bfs(){
        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(board[nextX][nextY] == 0){   // 안 익은 토마토라면
                    // 이전 날짜 + 1
                    board[nextX][nextY] = board[now.x][now.y] + 1;
                    q.offer(new Point(nextX, nextY));
                }
            }
        }

        int count = Integer.MIN_VALUE;  // 날짜 비교할 값

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    // 안 익은 것이 존재하면 -1 출력
                    return -1;
                }
                count = Math.max(count, board[i][j]);
            }
        }
        return count - 1;      // 아니면 count-1 해서 걸린 일수 출력
    }
}
//https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7576%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java