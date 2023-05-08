package Main;

import java.util.*;
import java.io.*;

class Main10026{
    static int N;    // 배열 크기
    static char[][] grid;    // RGB 값 넣을 배열
    static boolean[][] visited;        // 방문배열
    static int[] dx = {-1, 0, 1, 0};    // 좌 하 우 상
    static int[] dy = {0, 1, 0, -1};    // 좌 하 우 상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            grid[i] = temp.toCharArray();
        }

        int count = 0;      // 적록색약 아닐 때

        // 같은 색이면 dfs 들어가기, 다른 색이면 탈출
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }

        int countRG = 0;    // 적록색약일 때

        // 적록색약의 경우로 배열 변환
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == 'G'){
                    grid[i][j] = 'R';
                }
            }
        }
        // 방문 배열도 다시 생성
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    countRG++;
                }
            }
        }

        bw.write(count+" "+countRG);
        bw.close();
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        char temp = grid[x][y];

        // 좌 하 우 상 같은지 탐색
        for(int i=0; i<4; i++){
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];

            // grid 밖으로 넘어가면 생략
            if(temp_x < 0 || temp_y < 0 || temp_x >= N || temp_y >= N)
                continue;

            // 아직 미방문 and 같은 색이면 dfs 돌입
            if(!visited[temp_x][temp_y] && grid[temp_x][temp_y] == temp)
                dfs(temp_x, temp_y);
        }
    }
}
//https://nanchachaa.tistory.com/80