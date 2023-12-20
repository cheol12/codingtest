package Main;

import java.io.*;
import java.util.*;

public class Main1697_1{
    // 해당 위치에 도달하는 최소 시간을 나타내는 맵
    static int[] map = new int[100001];
    // 현재 위치 값을 표현하는 큐
    static Queue<Integer> q = new ArrayDeque<>();
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        bfs();

        bw.write(map[K] - 1 + "");
        bw.close();
    }

    static void bfs(){
        // 시작점을 1로
        map[N] = 1;
        q.offer(N);

        while(!q.isEmpty()){
            // 현재 수빈이의 위치
            int now = q.poll();
            if(now == K) return;

            if(2*now <= 100000 && map[2*now] == 0){
                map[2*now] = map[now] + 1;
                q.offer(2*now);
            }
            if(now+1 <= 100000 && map[now+1] == 0){
                map[now+1] = map[now] + 1;
                q.offer(now+1);
            }
            if(now-1 >= 0 && map[now-1] == 0) {
                map[now-1] = map[now] + 1;
                q.offer(now-1);
            }
        }
    }

}
