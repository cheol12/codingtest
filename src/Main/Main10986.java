package Main;

import java.io.*;
import java.util.*;

class Main10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        long[] S = new long[N+1];     // 합배열
        long[] C = new long[M]; // 합배열 % M을 동일하게 만들어주는 i,j를 담는 배열

        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(token.nextToken());
            S[i] = S[i-1] + temp;
        }

        // (A + B) % M = ((A % M) + (B % M)) % M
        // :: (A+B)의 나머지 연산은 ==
        // ((A의 나머지연산) + (B의 나머지 연산))의 나머지 연산 값과 같다는
        // 수학공식을 이용하여 시간초과를 방지한다.

        // 현재 문제에서는 구간의 합 S[j] - S[i-1]을 M으로 나눴을 때,
        // 나머지가 0인 i, j를 찾아야 한다.
        // 따라서, (S[j] - S[i-1]) % M -> 이 초기식을
        // 모듈러의 정리에 따라 분배 법칙을 적용하면
        // (S[j] % M) - (S[i-1] % M) = 0;
        // S[j] % M = S[i-1] % M

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            int remainder = (int) (S[i] % M);
            // 구간합 자체가 0이 된다면 정답 카운팅
            if(remainder == 0) answer++;

            C[remainder] ++;
        }

        for(int i=0; i<M; i++){
            // 나머지가 i인 것의 개수가 1개 보다 많을 때.
            if(C[i] > 1){
                // cnt = C[i] = 나머지가 i인 것의 개수
                long cnt = C[i];
                answer += (cnt * (cnt-1)) / 2;
            }
        }
        System.out.println(answer);
    }
}
//https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-10986-%EB%82%98%EB%A8%B8%EC%A7%80-%ED%95%A9

//    static int N,M;
//    static int[] arr;
//    static int[] sum;
//    static int count = 0;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer token;
//
//        token = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(token.nextToken());
//        M = Integer.parseInt(token.nextToken());
//
//        arr = new int[N+1];
//        sum = new int[N+1];
//        token = new StringTokenizer(br.readLine());
//        for(int i=1; i<=N; i++){
//            arr[i] = Integer.parseInt(token.nextToken());
//            sum[i] = sum[i-1] + arr[i];
//        }
//
//        partSum(1);
//        bw.write(count+"");
//        bw.close();
//    }
//
//    // (A + B) % M = ((A % M) + (B % M)) % M
//    // :: (A+B)의 나머지 연산은 ==
//    // ((A의 나머지연산) + (B의 나머지 연산))의 나머지 연산 값과 같다는
//    // 수학공식을 이용하여 시간초과를 방지한다.
//
//    static void partSum(int startIdx){
//
//        int temp;
//        for(int i=startIdx; i<=N; i++){
//            temp = sum[i];
//            for(int j=0; j<i; j++){
//                // i부터 j까지 더한 것
//                temp -= arr[j];
//                if(temp % M == 0) count++;
//            }
//        }
//    }
//}
//https://velog.io/@isohyeon/Java-%EB%B0%B1%EC%A4%80-10986-%EB%82%98%EB%A8%B8%EC%A7%80-%ED%95%A9