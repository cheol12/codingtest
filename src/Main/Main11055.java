package Main;

import java.io.*;
import java.util.*;

class Main11055{

    static int N;
    static int[] A, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        S = new int[N+1];
        int result = Integer.MIN_VALUE;

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(token.nextToken());
        }

        for(int i=1; i<=N; i++){

            S[i] = A[i];
            for(int j=1; j<i; j++){
                if(A[i] > A[j]){
                    S[i] = Math.max(S[j] + A[i], S[i]);
                }
            }
            result = Math.max(result, S[i]);
        }

        bw.write(result+"");
        bw.close();
    }
}
