package Main;

import java.io.*;
import java.util.*;

class Main9461_1{
    static int N;
    static int T;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;

        for(int j=3; j<=100; j++){
            dp[j] = dp[j-2] + dp[j-3];
        }

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());

            bw.write(dp[N]+"\n");
        }
        bw.close();
    }
}