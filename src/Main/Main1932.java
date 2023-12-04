package Main;

import java.io.*;
import java.util.*;

public class Main1932 {
    static int n;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        n = Integer.parseInt(br.readLine());
        triangle = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                triangle[i][j] = Integer.parseInt(token.nextToken());
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int answer = 0;

        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dp[n][i]);
        }


        bw.write(answer+"");
        bw.close();
    }

}
//https://dding9code.tistory.com/10