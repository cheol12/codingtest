package Main;

import java.util.*;
import java.io.*;

class Main11047 {
    public static void main(String args[]) throws IOException{
        //준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
        //동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int A[] = new int[N];

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            A[i] = a;
        }

        // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int X = 0;  // 동전 개수 합

        for(int i=1; i<=N; i++){
            if(K>=A[N-i]){
                X += K / A[N-i];
                K = K % A[N-i]; // 동전 개수 구하는 과정에서 나머지값 업데이트
            }

        }
        bw.write(String.valueOf(X));
        bw.close();
    }
}
