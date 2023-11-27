package Main;

import java.io.*;
import java.util.*;

class Main11053_1{

    static int N;
    static int[] A, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        S = new int[N+1];
        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(token.nextToken());
        }

        int result = 0;

        for(int i=1; i<=N; i++){
            S[i] = 1;
            for(int j=1; j<i; j++){
                if(A[i] > A[j]){
                    S[i] = Math.max(S[j] + 1, S[i]);
                }
            }
            result = Math.max(result, S[i]);
        }

        bw.write(result + "");
        bw.close();
    }
}