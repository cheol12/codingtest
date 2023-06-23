package Main;

import java.io.*;
import java.util.*;

class Main2573{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] north;
    static int N,M;
    static Queue<Point> q;
    static int cnt = 0; // 분리된 덩어리 개수
    static int ans = 0; // 분리될 때까지 걸리는 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        north = new int[N][M];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                north[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        while((cnt = SeparateCount()) < 2){
            // 문제에서 처음 입력시 "한 덩어리의 빙산이 주어진다"고 했기 떄문에
            // 처음에는 cnt = 1 이 나올 것이다.
            if(cnt == 0){
                ans = 0;
                break;
            }
            // 이후 반복문을 돌며 빙산을 1년 후의 상태로 녹이는 함수 실행.
            Melt();
            ans++;
        }
        bw.write(ans+"");
        bw.close();
    }

    static int SeparateCount(){
        visited = new boolean[N][M];

        int count = 0;

        for(int i = 0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || north[i][j] == 0)
                    continue;
                dfs(i, j, visited);
                count++;
            }
        }

        return count;
    }

    // 빙산 한 덩어리 내에 이어지는 곳들 방문 처리
    static void dfs(int x, int y, boolean[][] visited){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if(visited[nx][ny] || north[nx][ny] == 0)
                continue;

            dfs(nx, ny, visited);
        }
    }

    static void Melt(){
        visited = new boolean[N][M];
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(north[i][j] != 0){
                    // 아직 녹지 않은 것을 큐에 넣고
                    q.offer(new Point(i, j));
                    // 큐 안에 있던 Point들은 0이 아닌 것만 넣었지만
                    // 녹는 과정에서 0으로 변하게 될 수 있다.
                    // 그래서 다른 큐 원소들이 인접한 0의 개수를 판단할 때
                    // 이전에 녹은 건지 지금 녹은 건지 판단할 수 있도록
                    // 방문 처리한다.
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Point now = q.poll();
            int zeroCount = 0;
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if(visited[nx][ny] || north[nx][ny] != 0)
                    continue;
                zeroCount++;
            }

            if(north[now.x][now.y] <= zeroCount)
                north[now.x][now.y] = 0;
            else north[now.x][now.y] -= zeroCount;
        }
    }
}
//https://steady-coding.tistory.com/17