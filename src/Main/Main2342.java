package Main;

import java.util.*;
import java.io.*;

class Main2342{
    static int n;
    static long[][] D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        // N개 수열을 수행하였고, 왼쪽이 L 오른쪽이 R자리에 있을 때 최소 누적 힘
        int[][][] dp = new int[100001][5][5];

        // 한 발을 이동할 때 드는 힘을 미리 저장하기
        // mp[1][2] = 1에서 2로 이동할 때 드는 힘
        int[][] mp = {{0,2,2,2,2},
                      {2,1,3,4,3},
                      {2,3,1,3,4},
                      {2,4,3,1,3},
                      {2,3,4,3,1}};
        // 위1 왼2 밑3 오4

        // s = 단계
        int n=0, s=1;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<100001; k++){
                    dp[k][i][j] = 10000000; // 큰 수로 초기화
                }
            }
        }
        dp[0][0][0] = 0;

        token = new StringTokenizer(br.readLine());
        while(true){
            n = Integer.parseInt(token.nextToken());
            if(n == 0) break;   // 입력 0이면 바로 종료

            // n 입력 -> 1 2 2 4 0 이라면
            for(int i=0; i<5; i++){
                if(n == i) continue;    // 같은 자리에 두 발이 오면 안됨.
                for(int j=0; j<5; j++){
                    // 오른발을 n으로 옮겨서 현재 모습이 되었을 때 최소 힘 저장.
                    dp[s][i][n] = Math.min(dp[s-1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }

            //위에서 한 발 내딛고 아래에서 그 다음 내딛고

            for(int j=0; j<5; j++){
                if(n == j) continue;
                for(int i=0; i<5; i++){
                    // 왼발을 옮겨서 현재 모습이 되었을 때 최소의 힘 저장.
                    dp[s][n][j] = Math.min(dp[s-1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }

            s++;    //다음 n으로 내딛었을 경우로 넘어간다.
        }
        s--;    //반복문 끝나면 n의 개수와 일치시키기 위해 -1

        int min = 10000000;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                min = Math.min(min, dp[s][i][j]);
            }
        }

        bw.write(String.valueOf(min));
        bw.close();
    }
}