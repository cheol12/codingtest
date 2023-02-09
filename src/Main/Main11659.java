package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main11659 {
    // 문제 제목 : 구간 합 구하기 4
    // 알고리즘 분류 : 누적 합(구간 합)
    public static void main(String args[]) throws IOException{
        // 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

//        이중 for문 쓰면 시간 초과함

//        // ArrayList로 풀기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer token;
//
//        token = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(token.nextToken());    // N = 수의 개수
//        int M = Integer.parseInt(token.nextToken());    // M = 합 구하는 횟수
//
//        ArrayList<Integer> a = new ArrayList<>();   // N개의 수를 저장할 ArrayList객체

//        ArrayList<Integer> d = new ArrayList<>();   // a의 합 배열
//
//        token = new StringTokenizer(br.readLine());
//        int sum = 0;

//        // 합 배열 공식 S[i] = S[i-1] + A[i]
//        // 인덱스는 0부터 시작하지만
//        // 보통의 문제에서는 '첫 번째' 부터 시작하기 때문에 배열 크기 +1 하기.
//        // 배열은 비어있는 인덱스를 0으로 취급.
//        // 리스트는 인덱스 비어있으면 오류나기 때문에 d.add(0); 설정.
//        // 합 배열 계산 중, 인덱스 i-1의 값을 인식하기 위해 설정.
//        d.add(0);
//
//        for(int i=0; i<N; i++){
//            a.add(Integer.parseInt(token.nextToken())); // ArrayList객체인 a에 N개의 수 저장
//            sum += a.get(i);
//            d.add(sum);
//        }
//
//        for(int b=0; b<M; b++){
//            token = new StringTokenizer(br.readLine());
//            int i = Integer.parseInt(token.nextToken());
//            int j = Integer.parseInt(token.nextToken());
//
//            // 구간 i~j까지의 구간 합 구하기
//            // 구간합 = S[j] - S[i-1]
//            bw.write(String.valueOf(d.get(j)-d.get(i-1))+"\n");
//
//        }
//
//        bw.close();

        // 하루코딩 풀이
        // 배열로 풀기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());    // N = 수의 개수
        int M = Integer.parseInt(token.nextToken());    // M = 합 구하는 횟수

        // 합 배열 공식 S[i] = S[i-1] + A[i]
        // 인덱스는 0부터 시작하지만
        // 보통의 문제에서는 '첫 번째' 부터 시작하기 때문에 배열 크기 +1 하기.
        // 배열은 비어있는 인덱스를 0으로 취급.
        // 리스트는 인덱스 비어있으면 오류나기 때문에 d.add(0);으로 설정.
        int[] a = new int[N+1];   // 합 배열

        token = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            a[i] = a[i-1] + Integer.parseInt(token.nextToken());
        }

        for(int b=0; b<M; b++){
            token = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());

            // 구간 i~j까지의 구간 합 구하기
            // 구간합 = S[j] - S[i-1]
            bw.write(String.valueOf(a[j]-a[i-1]) + "\n");

        }

        bw.close();
    }
}
