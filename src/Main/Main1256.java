package Main;

import java.util.*;
import java.io.*;

public class Main1256 {
    static int N,M;
    static long K;
    static int[][] dict;
    // N개의 "a"
    // M개의 "z"
    // N개 a랑 M개의 z로 만든 문자열 중 K번째 문자열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Long.parseLong(token.nextToken());

        dict = new int[202][202];

        for(int i=0; i<=200; i++){
            dict[i][0] = 1; // 총 i개인데 z를 0개 쓰는 것 = a를 i개 쓰는 것
            dict[i][i] = 1; // 총 i개인데 a를 i개 쓰는 것 = z를 0개 쓰는 것
        }

        // "a" 3개와 "z" 3개로 만든 문자열 ( 아래처럼 해석 가능 )
        // => ("a" 3개와 "z" 2개로 만든 문자열) + ("a" 2개와 "z" 3개로 만든 문자열)

        for(int i=2; i<=200; i++){
            for(int j=1; j<i; j++){
                dict[i][j] = dict[i-1][j-1] + dict[i-1][j];
                // K가 넘어가면 최대값으로 저장
                if(dict[i][j] > 1000000000) dict[i][j] = 1000000000;
            }
        }

        // N+M = 총 문자 개수, M = z문자 개수 라고 할 때,
        // dict[N+M][M] = 총 N개 중 M개를 z로 선택했을 때 만들 수 있는 문자열의 개수
        if(dict[N+M][M] < K) bw.write(String.valueOf("-1"));
        else{
            // 총 개수도 z개수도 모두 사용할 때까지 반복하자
            while(!(N == 0 && M == 0)){

                // 총 개수 N+M 중 하나를 a로 선택하면 N+M에서 -1
                // dict[N+M-1][M] = dict[N+M][M]에서 dict[N+M-1]번째 까지는 a로 시작하는 것.
                // dict[N+M-1][M] >= K이면 a가 맨 앞자리에 있다는 뜻
                // 현재 K번째의 문자열의 맨 앞자리는 a이다. (K 갱신 안함)
                if(dict[N+M-1][M] >= K){
                    bw.write("a");  // a를 사용
                    // a를 사용했으므로 총 개수 N-- 하기
                    N--;
                }
                // K가 dict[N+M-1][M]를 벗어난다면 a가 맨 앞자리에 없다는 뜻
                // 현재 K번째의 문자열의 맨 앞자리는 z이다. (K 갱신)
                else{
                    bw.write("z");  // z를 사용
                    K = K - dict[N+M-1][M]; // a가 맨 앞자리인 개수만큼 뺀다.
                    // z를 사용했으므로 z의 개수인 M-- 하기
                    M--;
                }
            }
        }
        bw.close();
    }
}
//https://velog.io/@sungjin0757/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-1256%EB%B2%88-%EC%82%AC%EC%A0%84JAVA