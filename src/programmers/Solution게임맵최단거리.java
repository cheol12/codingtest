package programmers;

import java.util.*;

public class Solution게임맵최단거리 {
    public static void main(String args[]) throws Exception {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};
//        int[][] maps = {
//        {1,0,1,1,1},
//        {1,0,1,0,1},
//        {1,0,1,1,1},
//        {1,1,1,0,0},
//        {0,0,0,0,1}};

        System.out.println(solution(maps));
    }
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int solution(int[][] maps) {
        int answer = 0;

        // 0 = 벽 있음, 1 = 벽 없음
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);

        answer = visited[maps.length-1][maps[0].length-1];
        return answer == 0 ? -1 : answer;
    }

    static void bfs(int[][] maps, int[][] visited){

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));
        visited[0][0] = 1;

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if(maps[nx][ny] == 1 && visited[nx][ny] == 0){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
    }
}
