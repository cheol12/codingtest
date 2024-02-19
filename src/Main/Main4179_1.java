package Main;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4179_1 {
    static private class Point{
        int x,y, time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int R,C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> fq;   // 불 큐
    static Queue<Point> jq;   // 지훈이 큐
    static char[][] map;
    static int exitTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        map = new char[R][C];

        jq = new ArrayDeque<>();
        fq = new ArrayDeque<>();

        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(map[i][j] == 'J') jq.offer(new Point(i, j, 0));
                else if(map[i][j] == 'F') fq.offer(new Point(i, j, 0));
            }
        }

        BFS(map);

        if(exitTime == 0) bw.write("IMPOSSIBLE");
        else bw.write(exitTime + "");
        bw.close();
    }

    static void BFS(char[][] map){

        while(!jq.isEmpty()){
            // 지훈이가 탈출하는 것이 목적 => 지훈이 큐를 while 조건으로 둔다.
            // '1초마다 불이 번진다' + '두 가지 큐가 존재' 하기 때문에
            // 1초마다 두 큐의 반복문을 따로 돌려야 한다.
            // 두 큐 객체의 사이즈도 while문 진행할 때마다 갱신되기 때문에
            // fq.size(); 를 쓰지 않고 따로 객체로 정의해서 매번 사이즈값을 바꿔서 해야한다.
            // (처음엔 아무 생각없이 fq.size();를 사용했다.)
            int fqSize = fq.size();

            // 로직상 불 큐 반복문을 먼저 돌리는 이유
            // : 지훈이와 불은 같이 움직이지만,
            //   불은 지훈이에 영향을 받지 않고 지훈이는 불에 영향을 받으며 움직인다.
            //   그래서 영향을 받는 지훈이큐의 반복문을 뒤에서 실행한다.
            for(int i=0; i<fqSize; i++){
                Point now = fq.poll();
                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                    map[nx][ny] = 'F';
                    fq.offer(new Point(nx, ny, now.time + 1));
                }
            }

            int jqSize = jq.size();
            for(int i=0; i<jqSize; i++){
                Point now = jq.poll();
                for(int j=0; j<4; j++){
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        exitTime = now.time + 1;
                        return;
                    }
                    if(map[nx][ny] != '.') continue;
                    map[nx][ny] = 'J';
                    jq.offer(new Point(nx, ny, now.time + 1));
                }
            }
        }
        return;
    }
}
