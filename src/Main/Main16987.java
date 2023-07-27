package Main;

import java.io.*;
import java.util.*;

class Main16987{
    // 내구도 무게
    // 상대 무게만큼 내구도가 깎인다
    // 내구도가 0이하가 되는 순간 계란은 깨진다
    static class egg{
        int dura, weight;
        egg(int dura, int weight){
            this.dura = dura;
            this.weight = weight;
        }
    }
    static int N ;
    static egg[] egg;
    static int breakCount = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        egg = new egg[N];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(token.nextToken());
            int W = Integer.parseInt(token.nextToken());
            egg[i] = new egg(S, W);
        }

        // th = 깰 th번째 계란, count = 현재 깨진 계란 개수
        DFS(0, 0);
        bw.write(breakCount+"");
        bw.close();
    }

    static void DFS(int th, int count){
        breakCount = Math.max(breakCount, count);
        if(th == N){
            return;
        }
        if(egg[th].dura <= 0){
            DFS(th+1, count);
            return;
        }

        // 다른 계란과 부딪히는 과정
        for(int i=0; i<N; i++){
            int temp = 0;
            if(th == i) continue;
            if(egg[i].dura <= 0) continue;

            egg[th].dura -= egg[i].weight;
            egg[i].dura -= egg[th].weight;

            if(egg[th].dura <= 0) temp++;
            if(egg[i].dura <= 0) temp++;

            DFS(th+1, count+temp);

            egg[th].dura += egg[i].weight;
            egg[i].dura += egg[th].weight;
        }
    }
}
//https://jiyoungtt.tistory.com/98?category=950414