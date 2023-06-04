package Main;

import java.io.*;
import java.util.*;

class Main10026_bfs{
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] grid;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];

        for(int i=0; i<N; i++){
            grid[i] = br.readLine().toCharArray();
        }

        int answer1 = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 조건을 if(!visited[i][j]) 로 하는 이유 :
                // 같은 색깔은 한 번의 bfs() 안에서 다 방문처리 된다
                if(!visited[i][j]){
                    bfs(i, j);
                    answer1++;
                }
            }
        }

        // 색약인 경우로 변경
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 'G') grid[i][j] = 'R';
            }
        }
        int answer2 = 0;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    answer2++;
                }
            }
        }

        bw.write(answer1 + " " + answer2);
        bw.close();
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(visited[nx][ny] || grid[nx][ny] != grid[x][y])
                continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
//nanchachaa.tistory.com/80