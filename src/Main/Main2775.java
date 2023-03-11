package Main;

import java.util.*;
import java.io.*;

class Main2775{
    //수학
    //구현
    //다이나믹 프로그래밍
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int k,n;    // 층수, 호수

        int[][] c = new int[15][15];    // 0열은 논외로 취급

        for(int i=1; i<15; i++){    //초기화
            c[0][i] = i;
            c[i][1] = 1;
        }

        // 배열 나머지 채우기
        for(int i=1; i<15; i++){
            for(int j=2; j<15; j++){
                // 2행 2열 = 2행 1열 + 1행 2열
                c[i][j] = c[i][j-1] + c[i-1][j];
            }
        }

        for(int i=0; i<T; i++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(c[k][n])+"\n");
        }
        bw.close();
    }
}