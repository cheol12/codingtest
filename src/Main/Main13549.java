package Main;

import java.io.*;
import java.util.*;

class Main13549{
    static class Point{
        int x, time;
        Point(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
    static int N,K;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        visited = new boolean[100001];
        bfs();
        bw.write(result+"");
        bw.close();
    }

    static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(N, 0));

        while(!q.isEmpty()){
            Point now = q.poll();
            visited[now.x] = true;

            if(now.x == K) result = Math.min(result, now.time);

            if(now.x * 2 <= 100000 && !visited[now.x * 2])
                q.offer(new Point(now.x * 2, now.time));

            if(now.x + 1 <= 100000 && !visited[now.x + 1])
                q.offer(new Point(now.x + 1, now.time + 1));

            if(now.x - 1 >= 0 && !visited[now.x - 1])
                q.offer(new Point(now.x - 1, now.time + 1));
        }
    }
}
//https://moonsbeen.tistory.com/97