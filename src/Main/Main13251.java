package Main;

import java.io.*;
import java.util.*;

public class Main13251 {
    //수학
    //조합론
    //확률론
    public static void main(String[] args) throws IOException{
        // 수학적 해석 :
        // ex) 입력값이 M = 3, N = 5,6,7, K = 2 라면
        // 식 도출 = 5C2 + 6C2 + 7C2 / 18C2
        // = 각 색상에서 2개를 뽑을 경우를 총 개수 중 2개를 뽑을 경우로 나눈다.
        // = 이는 곧 뽑은 조약돌이 모두 같은 색일 확률

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int M = Integer.parseInt(br.readLine());    // 조약돌의 색상 개수
        int N;    // 각 색상의 조약돌 개수
        int stone_sum = 0;    // 총 조약돌 개수 sum = N * M
        double combi_sum = 0;   // 조합값 더한 값
        int[] stone_each = new int[M];    // 색상 하나의 조약돌 개수 입력=N

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            // 임의의 색상 하나의 조약돌 개수
            N = Integer.parseInt(token.nextToken());
            // b[i]에 임의의 색상 하나의 조약돌 개수를 입력
            stone_each[i] = N;
            stone_sum += N;
        }

        // 분명 답은 맞는데 제출할 때 계속 틀려서 시간을 많이 허비함.
        // 이를 int->double 형으로 바꾸니 제출 성공.
        // 총 조약돌 개수만큼 배열 생성.
        double[][] D = new double[stone_sum+1][stone_sum+1];

        // 배열 초기화
        for(int i=1; i<=stone_sum; i++){
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }

        // 배열 설정
        for(int i=3; i<=stone_sum; i++){
            for(int j=2; j<i; j++){
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }

        // 랜덤하게 선택할 조약돌 개수
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            // 반복문마다 NCK 계산하여 sum1에 더하기
            combi_sum += D[stone_each[i]][K];
        }

        // combi_sum = 5C2 + 6C2 + 7C2, D[stone_sum][K] = 18C2
        double result = combi_sum / D[stone_sum][K];

        bw.write(String.valueOf(result));
        bw.close();

    }
}
