package Main;

import java.io.*;
import java.util.*;

class Main2667{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};    // 상 하 좌 우
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static int danjiNum = 0;
    static Queue<Point> q;
    static int aptCount;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        q = new LinkedList<>();
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(temp.substring(j, j+1));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    aptCount = 0;
                    q.offer(new Point(i, j));
                    visited[i][j] = true;
                    bfs();
                    danjiNum++;
                    list.add(aptCount);
                }
            }
        }
        Collections.sort(list);
        bw.write(danjiNum+"\n");
        for(int i=0; i<list.size(); i++){
            bw.write(list.get(i)+"\n");
        }
        bw.close();
    }

    static void bfs(){

        while(!q.isEmpty()){
            Point now = q.poll();
            aptCount++;

            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if(map[nx][ny] == 0 || visited[nx][ny])
                    continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}