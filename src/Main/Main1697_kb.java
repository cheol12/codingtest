package Main;

import java.io.*;
import java.util.*;

class Main1697_kb{
    static int[] arr;
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        arr = new int[100001];

        BFS(N);

        bw.write(arr[K] + "");
        bw.close();
    }

    static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        arr[x] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == K) return;

            if(now+1 <= 100000 && arr[now+1] == 0){
                arr[now+1] = arr[now] + 1;
                q.offer(now+1);
            }
            if(now-1 >= 0 && arr[now-1] == 0){
                arr[now-1] = arr[now] + 1;
                q.offer(now-1);
            }
            if(now*2 <= 100000 && arr[now*2] == 0){
                arr[now*2] = arr[now] + 1;
                q.offer(now*2);
            }
        }
    }
}