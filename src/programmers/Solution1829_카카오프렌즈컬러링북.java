package programmers;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution1829_카카오프렌즈컬러링북 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int m = 6;
        int n = 4;

        int[][] picture = new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}};
        bw.write(Arrays.toString(solution(m, n, picture)));

        bw.close();
    }
    static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        visited = new boolean[m][n];
        q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] > 0){
                    visited[i][j] = true;
                    q.offer(new Point(i, j));
                    int temp = bfs(m, n, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, temp);
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int bfs(int m, int n, int[][] picture){
        int count = 0;
        while(!q.isEmpty()) {
            Point now = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if (visited[nx][ny] || picture[nx][ny] != picture[now.x][now.y])
                    continue;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }

        return count;
    }
}