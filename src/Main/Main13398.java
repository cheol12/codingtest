package Main;

import java.io.*;
import java.util.*;

public class Main13398 {
    // DP(부분 합)
    static int n;   // 정수 개수
    static int[] seq;   // 수열 나타낼 배열
    public static void main(String[] args) throws IOException{
        //배열 속 '연속'된 숫자들을 선택해서 합이 가장 크게 나오는 경우를 출력
        //숫자 하나는 제거해도 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        n = Integer.parseInt(br.readLine());
        seq = new int[n+1];
        int[][] sum = new int[n+1][2];
        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            seq[i] = Integer.parseInt(token.nextToken());
        }

        // 부분합 중에 인덱스 1이 마지막이고 수 하나를 제거하는 경우의 최대값
        sum[1][0] = 0;
        // 부분합 중에 인덱스 1이 마지막이고 수를 제거하지 않은 경우의 최대값
        sum[1][1] = seq[1];

        // 출력할 최대값
        int result = sum[1][1];

        for(int i=2; i<=n; i++){
            // 원래 제거값을 제거하는 것이 최대인 경우, 새로운 값을 제거하는 게 최대인 경우
            sum[i][0] = Math.max(sum[i-1][0] + seq[i], sum[i-1][1]);
            // 이전 합+새로운 값이 최대인 경우, 새로운 값이 더 큰 경우
            sum[i][1] = Math.max(sum[i-1][1] + seq[i], seq[i]);

            // sum 배열 안의 모든 값 중 최대값을 선택한다.
            // 결과로 나온 최대값과 설정해둔 result값을 다시 비교해서 최종 출력.
            result = Math.max(result, Math.max(sum[i][0], sum[i][1]));
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}
// https://lotuslee.tistory.com/90