package Main;

import java.util.*;
import java.io.*;

public class Main1463 {
    // 다이나믹 프로그래밍
    static int N;
    static int[] D; // 연산 횟수 최소값을 저장하는 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        D = new int[N+1];
        // 초기화
        D[1] = 0;

        // D[i] = i가 1이 될 때까지의 연산 횟수의 최솟값을 입력.
        for(int i=2; i<=N; i++){
            D[i] = D[i-1] + 1;  // 1을 빼는 연산

            if(i % 2 == 0){
                D[i] = Math.min(D[i], D[i/2] + 1);  // 2로 나누는 연산
            }
            if(i % 3 == 0){
                D[i] = Math.min(D[i], D[i/3] + 1);  // 3으로 나누는 연산
            }
        }

        bw.write(String.valueOf(D[N]));
        bw.close();
    }
}
