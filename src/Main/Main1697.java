package Main;

import java.util.*;
import java.io.*;

public class Main1697 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        arr = new int[100001];

        bw.write(bfs(N)+"");
        bw.close();
    }

    static int bfs(int index){
        Queue<Integer> q = new LinkedList<>();

        q.offer(index);
        arr[index] = 0;

        while(!q.isEmpty()){
            int now = q.poll(); // 현재 인덱스

            if(now == K){
                return arr[now];
            }
            if(now-1>=0 && arr[now-1] == 0){
                arr[now-1] = arr[now] + 1;
                q.offer(now-1);
            }
            if(now+1<=100000 && arr[now+1] == 0){
                arr[now+1] = arr[now] + 1;
                q.offer(now+1);
            }
            if(now*2<=100000 && arr[now*2] == 0){
                arr[now*2] = arr[now] + 1;
                q.offer(now*2);
            }
        }
        return -1;
    }
}//https://smartpro.tistory.com/18