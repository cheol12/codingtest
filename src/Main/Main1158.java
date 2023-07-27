package Main;

import java.io.*;
import java.util.*;

class Main1158{
    static int N,K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            q.offer(i);
        }

        int index = 0;
        while(!q.isEmpty()){
            int poll_value = q.poll();
            if(++index % K == 0) sb.append(poll_value + ", ");
            else q.offer(poll_value);
        }

        sb.delete(sb.length()-2, sb.length());
        bw.write(sb+">");
        bw.close();
    }
}
