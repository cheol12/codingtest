package programmers;

import java.util.*;
import java.io.*;

//프로그래머스.
// 2021 카카오 채용연계형 인턴십 문제.
// 거리두기 확인하기 -
class Solution81302 {

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dx_cross = {-1, 1, 1, -1}; // 왼아, 오른아, 오른위, 왼위
    static int[] dy_cross = {1, 1, -1, -1}; //
    static Queue<Point> q;
    static boolean[][] visited;
    static char[][] table;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int n = 5;
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        bw.write(Arrays.toString(solution(places)));

        bw.close();
    }

    static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i=0; i<5; i++){
            table = new char[5][5];
            visited = new boolean[5][5];

            for(int j=0; j<5; j++){
                table[i] = places[i][j].toCharArray();
            }

            q = new LinkedList<>();

            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(table[j][k] == 'P') q.offer(new Point(j, k));
                }
            }
            answer[i] = bfs();
        }
        return answer;
    }


    static int bfs(){
        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                    continue;
                if(table[nx][ny] == 'P') {
                    return 0;
                }
            }
//
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i]*2;
                int ny = now.y + dy[i]*2;

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                    continue;
                if(table[nx][ny] == 'P'){
                    if(table[now.x + dx[i]][now.y + dy[i]] != 'X')
                        return 0;
                    else continue;
                }
            }

            // 왼위, 왼아래, 오른위, 오른아래
            for(int i=0; i<4; i++){
                int nx = now.x + dx_cross[i];
                int ny = now.y + dy_cross[i];

                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
                    continue;
                if(table[nx][ny] == 'P'){
                    if(table[now.x + dx_cross[i]][now.y] != 'X' ||
                            table[now.x][now.y + dy_cross[i]] != 'X')
                        return 0;
                    else continue;
                }
            }
            visited[now.x][now.y] = true;
        }
        return 1;
    }
}