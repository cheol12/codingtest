package Main;

import java.io.*;
import java.util.*;

class Main1003{
    static int T,N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());

            for(int j=2; j<=N; j++){
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }
        bw.close();
    }

//    static int fibonacci(int N){
//        if(dp[N][0] == -1 || dp[N][1] == -1){
//            dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[1];
//        }
//    }
}