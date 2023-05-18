package Main;

import java.io.*;
import java.util.*;

class Main1149 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());

        int[][] RGBdist = new int[N+1][3];
        int[][] dp;

        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            RGBdist[i][0] = Integer.parseInt(token.nextToken());
            RGBdist[i][1] = Integer.parseInt(token.nextToken());
            RGBdist[i][2] = Integer.parseInt(token.nextToken());

        }

        dp = RGBdist.clone();

        // 처음 구현한 방식 : 처음 집에서 RGB 중 최소값과 그를 가리키는 인덱스를 구했다.
        // 그 후 다음 집에서는, 이전 집에서 채택한 색깔을 제외하고
        // 나머지 두 색깔 중 최소값을 구하며 이들을 더해갔다.
        // 결과 : 예제 입력 5를 통과하지 못했다. 마지막에

        // 정답 방식 : i번째 집을 R로 택할 경우, G로 택할 경우, B로 택할 경우를
        // 각각 생각하며 합을 갱신해 갔다.

        // dp배열처럼 배열을 따로 복사하지 않고 본래 배열인 RGBdist 에서 그대로
        // 덧붙여가며 합을 구하는 방식 = 메모이제이션.
       for(int i=1; i<=N; i++){
            dp[i][0] += Math.min(RGBdist[i-1][1], RGBdist[i-1][2]);
            dp[i][1] += Math.min(RGBdist[i-1][0], RGBdist[i-1][2]);
            dp[i][2] += Math.min(RGBdist[i-1][0], RGBdist[i-1][1]);
        }

        int result = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        bw.write(result+"");
        bw.close();
    }
}
//https://st-lab.tistory.com/128