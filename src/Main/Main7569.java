package Main;

import java.io.*;
import java.util.*;

class Main7569{
    static class Point{
        int x,y,z;
        Point(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    static int[][][] box;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};  // 좌 하 우 상 위 아래
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int H, M, N;
    static Queue<Point> q;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        box = new int[H][N][M];
        q = new LinkedList<>();

        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                token = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    box[k][i][j] = Integer.parseInt(token.nextToken());

                    if(box[k][i][j] == 1) q.offer(new Point(k,i,j));
                }
            }
        }

        bfs();
        bw.write(answer+"");
        bw.close();
    }

    static void bfs(){

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<6; i++){
                int nz = now.z + dz[i];
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M)
                    continue;
                if(box[nz][nx][ny] == 0){
                    box[nz][nx][ny] = box[now.z][now.x][now.y] + 1;
                    q.offer(new Point(nz, nx, ny));

                }
            }
        }

        int count = 0;
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(box[k][i][j] == 0) {
                        answer = -1;
                        return;
                    }
                    answer = Math.max(answer, box[k][i][j]);

                }
            }
        }
        answer -= 1;    // 익는 데까지 소요된 날짜이므로 -1한다.
        return;
    }

}