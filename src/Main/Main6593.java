package Main;

import java.io.*;
import java.util.*;

class Main6593 {
    static class Point {
        int x, y, z, time;

        Point(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static char[][][] sangbum;
    static boolean[][][] visited;
    static Queue<Point> q;
    static int L,R,C;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        while(true){

            token = new StringTokenizer(br.readLine());
            L = Integer.parseInt(token.nextToken());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            sangbum = new char[L][R][C];
            visited = new boolean[L][R][C];
            q = new LinkedList<>();

            for(int i=0; i<L; i++){

                for(int j=0; j<R; j++){
                    sangbum[i][j] = br.readLine().toCharArray();
                    for(int k=0; k<C; k++){
                        if(sangbum[i][j][k] == 'S'){
                            q.offer(new Point(i, j, k, 0));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }
            if(bfs()) bw.write("Escaped in " + answer + " minute(s).\n");
            else bw.write("Trapped!\n");
        }

        bw.close();
    }

    static boolean bfs(){

        while(!q.isEmpty()){
            Point now = q.poll();
            if(sangbum[now.x][now.y][now.z] == 'E') {
                answer = now.time;
                return true;
            }
            for(int i=0; i<6; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C)
                    continue;
                if(visited[nx][ny][nz] || sangbum[nx][ny][nz] == '#')
                    continue;
                visited[nx][ny][nz] = true;
                q.offer(new Point(nx, ny, nz, now.time + 1));
            }
        }
        return false;
    }
}