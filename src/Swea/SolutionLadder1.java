package Swea;

import java.util.*;
import java.io.*;

public class SolutionLadder1 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int BFS(int[][] sadari, int x, int y){
        boolean[][] visited = new boolean[100][100];
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(true){
            Point now = q.poll();

            for(int i=0; i<3; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(ny == 0){
                    return nx;
                }

                if(nx < 0 || nx > 99 || ny < 0 || ny > 99) continue;
                if(visited[nx][ny]) continue;
                if(sadari[nx][ny] == 0) continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                break;
            }
        }

    }
    static Queue<Point> q;
    // 왼쪽, 오른쪽, 위 순서로 판별
    static int[] dx = {-1, 1, 0};
    static int[] dy = {0, 0, -1};

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        int T = 10;
        int[][] sadari;

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(br.readLine());
            sadari = new int[100][100];

            q = new ArrayDeque<>();
            int finishX = -1;
            int finishY = 99;
            boolean up = true;

            for(int i=0; i<100; i++){
                token = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    sadari[j][i] = Integer.parseInt(token.nextToken());
                    if(sadari[j][i] == 2) finishX = j;
//                    if(j == 0 && sadari[i][j] == 1) startLineQ.offer();
                }
            }

            bw.write("#" + test_case + " " + BFS(sadari, finishX, finishY) + "\n");
            // 도착지점 = j, 99
            // 도착지점부터 시작지점까지 거꾸로 올라가기

            // 옆에 없으면 위로, 있으면 옆으로

        }
        bw.close();
    }
}
