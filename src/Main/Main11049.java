package Main;

import java.util.*;
import java.io.*;

class Main11049{
    static int n, INF = Integer.MAX_VALUE;
    static int[][] matrix;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        n = Integer.parseInt(br.readLine());

        // matrix[i][0] = i번째 행렬의 행 개수
        // matrix[i][1] = i번째 행렬의 열 개수
        matrix = new int[n][2];

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(token.nextToken());
            matrix[i][1] = Integer.parseInt(token.nextToken());
        }

        int size = n;
        dp = new int[n][n];

        for(int i=0; i<n-1; i++){
            dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
            // matrix[i][1] 대신 matrix[i+1][0] 도 가능
        }

        for(int gap=2; gap<n; gap++){
            for(int i=0; i+gap<n; i++){
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;   // 초기화
                for(int k = i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k+1][j]
                                    + (matrix[i][0]*matrix[k][1]*matrix[j][1]));
                }
            }
        }
        bw.write(String.valueOf(dp[0][n-1]));
        bw.close();
    }
}