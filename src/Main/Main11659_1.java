package Main;

import java.io.*;
import java.util.*;

class Main11659_1{
    static int N, M;
    static int[] arr, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N+1];
        S = new int[N+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
            S[i] = S[i-1] + arr[i];
        }

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            int partSum = S[end] - S[start-1];
            bw.write(partSum + "\n");
        }
        bw.close();
    }
}