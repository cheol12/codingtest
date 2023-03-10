package Main;

import java.io.*;
import java.util.*;

class Main11050 {
//수학
//구현
//조합론

    public static void main(String args[]) throws IOException{
    //첫째 줄에 N과 K가 주어진다.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        // 0부터 시작하는 특성 때문에 크기 +1
        int[][] a = new int[N+1][N+1];

        // 배열 초기화
        for(int i=0; i<=N; i++){
            a[i][i] = 1;
            a[i][0] = 1;
            a[i][1] = i;
        }

        // 점화식으로 배열 마저 완성하기
        for(int i=3; i<=N; i++){    // 초기화 과정에서 i=0,1,2까지 이미 입력함.
            for(int j=2; j<i; j++){
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }

        bw.write(Arrays.deepToString(a));
        bw.write(String.valueOf(a[N][K]));
        bw.close();
    }
}
