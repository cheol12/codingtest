package Main;

import java.io.*;
import java.util.*;

class Main5427{
    static class Point{
        int x, y, time;
        Point(int x, int y, int time ){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};    // 상 하 좌 우
    static Queue<Point> sq;
    static Queue<Point> fq;
    static char[][] building;
    static int T, w, h;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            token = new StringTokenizer(br.readLine());
            w = Integer.parseInt(token.nextToken());
            h = Integer.parseInt(token.nextToken());
            building = new char[h][w];
            sq = new LinkedList<>();
            fq = new LinkedList<>();

            for(int j=0; j<h; j++){
                building[j] = br.readLine().toCharArray();
                for(int k=0; k<w; k++){
                    if(building[j][k] == '@')
                        sq.offer(new Point(j, k, 0));
                    else if(building[j][k] == '*')
                        fq.offer(new Point(j, k, 0));
                }
            }
            count = 0;
            bfs();

            if(count > 0) bw.write(count + "\n");
            else bw.write("IMPOSSIBLE\n");
        }

        bw.close();
    }

    static void bfs(){

        while(!sq.isEmpty()){
            int fqsize = fq.size();
            for(int i=0; i<fqsize; i++){
                Point now = fq.poll();

                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue;
                    if(building[nx][ny] == '*' || building[nx][ny] == '#')
                        continue;
                    building[nx][ny] = '*';
                    fq.offer(new Point(nx, ny, now.time + 1));
                }
            }

            // sq.size(); 를 바로 호출하면 안되는 이유?
            int sqsize = sq.size();
            for(int i=0; i<sqsize; i++){
                Point now = sq.poll();

                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                        count = now.time + 1;
                        return;
                    }
                    if(building[nx][ny] != '.')
                        continue;
                    building[nx][ny] = '@';
                    sq.offer(new Point(nx, ny, now.time + 1));
                }
            }
        }
    }
}