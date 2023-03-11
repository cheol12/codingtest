package Main;

import java.io.*;
import java.util.*;

public class Main1010 {
    //수학
    //다이나믹 프로그래밍
    //조합론

    //"중복 없이 뽑는 것은 이해하겠는데, 다리가 교차되면 어떻게 되나요..?"
    //예로들어 (1, 2, 3, 4, 5) 에서 (1, 3, 4) 를 뽑았다고 해보자.
    //이는 (3, 1, 4)이나, (3, 4, 1) 등 순서가 다르게 뽑혀도 조합은 뽑는
    //순서를 고려하지 않기 때문에 모두 1개의 경우로 보는 것이다.
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());

        // 동쪽 사이트는 M개 중 N개를 선택
        int N,M;

        int[][] a = new int[30][30];

        for(int i=0; i<30; i++){
            a[i][0] = 1;
            a[i][i] = 1;
            a[i][1] = i;
        }

        for(int i=3; i<30; i++){
            for(int j=2; j<i; j++){
                a[i][j] = a[i-1][j-1] + a[i-1][j];
            }
        }

        for(int i=0; i<T; i++){
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            bw.write(String.valueOf(a[M][N])+"\n");
        }
        bw.close();
    }
}