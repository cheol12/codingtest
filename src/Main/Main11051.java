package Main;

import java.io.*;
import java.util.*;

class Main11051 {
    //수학
    //다이나믹 프로그래밍
    //조합론
    static int N,K;
    static int[][] a;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());    // 총 수
        K = Integer.parseInt(token.nextToken());    // 선택 수
        a = new int[N+1][N+1];    // N개 중 0~N개 선택하는 모든 경우를 나타내는 배열

        // 배열 초기화
        for(int i=0; i<=N; i++){
            a[i][0] = 1;    // i개 중 0개 선택하는 경우의 수
            a[i][i] = 1;    // i개 중 i개
            a[i][1] = i;    // i개 중 1개
        }

        // 배열 마저 채우기 (i개 중 j개 선택)
        for(int i=3; i<=N; i++){
            for(int j=2; j<i; j++){
                a[i][j] = (a[i-1][j] + a[i-1][j-1]) % 10007 ;
            }
        }
        bw.write(String.valueOf(a[N][K]));
        bw.close();

    }
}