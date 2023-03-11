package Main;

import java.io.*;
import java.util.*;

public class Main13251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int M = Integer.parseInt(br.readLine());    // 조약돌의 색상 개수
        int N;    // N * M = 총 조약돌의 개수

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            // 임의의 색상 하나의 조약돌 개수
            N = Integer.parseInt(token.nextToken());

        }

        int K = Integer.parseInt(br.readLine());    // 랜덤하게 뽑을 개수


    }
}
