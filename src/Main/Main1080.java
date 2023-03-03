package Main;

import java.io.*;
import java.util.*;

public class Main1080 {
    // 그리디 알고리즘

    public static void main(String args[]) throws IOException{
        // 0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로
        // 바꾸는데 필요한 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오.
        // 행렬을 변환하는 연산은 어떤 3×3크기의 부분 행렬에 있는
        // 모든 원소를 뒤집는 것이다. (0 → 1, 1 → 0)

        // 입력 : 첫째 줄에 행렬의 크기 N, M 입력. N, M은 50보다 작거나 같은 자연수.
        // 둘째 줄부터 N개의 줄에는 행렬 A가 주어지고,
        // 그 다음줄부터 N개의 줄에는 행렬 B가 주어진다.

        // 출력 : 연산 횟수 최솟값 출력, A를 B로 바꿀 수 없다면 -1 출력.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        StringTokenizer token1;

        token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());    // N행
        int M = Integer.parseInt(token.nextToken());    // M열

        int[][] A = new int[N][M];  // N행 M열 - 행렬A
        for(int i=0; i<N; i++){
            token1 = new StringTokenizer(br.readLine(),"");
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(token1.nextToken());
            }
        }

        int[][] B = new int[N][M];  // N행 M열 - 행렬B
        for(int i=0; i<N; i++){
            token1 = new StringTokenizer(br.readLine(),"");
            for(int j=0; j<M; j++){
                B[i][j] = Integer.parseInt(token1.nextToken());
            }
        }
        bw.write(Arrays.deepToString(A));
        bw.close();
    }

}

