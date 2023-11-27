package Main;

import java.io.*;
import java.util.*;

class Main11047_1{
    static int N,K;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        A = new int[N+1];

        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for(int i=N; i>=1; i--){
            if(K / A[i] >= 1){
                count += K / A[i];
                K %= A[i];
            }
        }

        bw.write(count+"");
        bw.close();
    }
}