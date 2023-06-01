package Main;

import java.util.*;
import java.io.*;

public class Main4179 {
    static class Point{
        int x, y, time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int R, C; // 행, 열
    static int[] dx = {-1, 0, 1, 0};    // 좌 하 우 상
    static int[] dy = {0, 1, 0, -1};    // 좌 하 우 상
    static char[][] maze;    // =미로, 영어로 maze
    static Queue<Point> jq, fq;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        maze = new char[R][C];
        jq = new LinkedList<>();
        fq = new LinkedList<>();

        // # = 벽
        // . = 공간
        // J = 시작점(공간)
        // F = 불이 난 공간

        // F 가 상하좌우로 확산

        for(int i=0; i<R; i++){
            maze[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(maze[i][j] == 'J')
                    jq.offer(new Point(i, j, 0));
                else if(maze[i][j] == 'F')
                    fq.offer(new Point(i, j, 0));
            }
        }

        if(bfs()) bw.write(answer + "");
        else bw.write("IMPOSSIBLE");
        bw.close();
    }

    static boolean bfs(){

        // 불 확산을 먼저 계산한다
        while(!jq.isEmpty()){
            int f_size = fq.size();
            for(int i=0; i<f_size; i++){
                Point now = fq.poll();

                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(maze[nx][ny] == 'J' || maze[nx][ny] == '.') {
                        maze[nx][ny] = 'F';
                        fq.offer(new Point(nx, ny, now.time + 1));
                    }
                }
            }

            int j_size = jq.size();

            for(int i=0; i<j_size; i++){
                Point now = jq.poll();

                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        // 범위를 벗어나면 탈출 성공한 것.
                        answer = now.time + 1;
                        return true;
                    }

                    if(maze[nx][ny] == '.'){
                        maze[nx][ny] = 'J';
                        jq.offer(new Point(nx, ny, now.time + 1));
                    }
                }
            }
        }
        // 코드 진행상 여기에 도달하면 지훈이가 범위를 벗어나지 못한 것
        return false;
    }
}
//https://developer-ellen.tistory.com/155?category=879172