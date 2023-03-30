package Main;

import java.util.*;
import java.io.*;

class Main10844{
    static int N;
    static long[][] stairs;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long mod = 1000000000;
        N = Integer.parseInt(br.readLine());
        stairs = new long[N+1][10];

        for(int j=0; j<=9; j++){
            // 한 자리수인데 i로 시작하는 것의 개수, 숫자 0도 한 개로 취급.
            stairs[1][j] = 1;
        }

        // 2자리수 부터
        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                // stairs[i][j] = 자릿수가 i이고 맨 앞자리가 j인 숫자
                if(j == 0) stairs[i][j] = stairs[i-1][j+1];
                else if(j == 9) stairs[i][j] = stairs[i-1][j-1];
                else stairs[i][j] = stairs[i-1][j-1] + stairs[i-1][j+1];

                stairs[i][j] %= mod;

                // i자리수의 0~9로 시작하는 숫자를 구할 때 :
                // 1~8까지는 각자 양쪽에 있는 숫자를 참고할 수 있다.
                // 1로 시작하는 숫자가 계단 수가 되려면 1 다음에 올
                // 두 번째 숫자는 무조건 0or2 이다.
                // 이는 이전 자릿수의 (0으로 시작하는 수 + 2로 시작하는 수)이다.
                // 따라서 0으로 시작하고 자릿수가 i-1인 계단 수와
                // 2로 시작하고 자릿수가 i-1인 계단 수의 개수를 더하면
                // 1로 시작하는 자릿수가 i인 계단 수의 개수를 구할 수 있다.
                // 0,9는 각각 1,8만 참고 가능하다.
            }
        }
        long result = 0;
        for(int j=1; j<=9; j++){
            result += stairs[N][j];
        }
        bw.write(String.valueOf(result % mod));
        bw.close();
    }
}
//https://moonsbeen.tistory.com/18