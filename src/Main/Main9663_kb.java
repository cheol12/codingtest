package Main;

import java.io.*;
import java.util.*;

public class Main9663_kb {
    static int N;
    static int[] chess;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        chess = new int[N];

        DFS(0);
        bw.write(count + "");
        bw.close();
    }

    static void DFS(int th){
        if(th == N){
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            chess[th] = i;
            if(Possible(th)) DFS(th+1);
        }
    }

    static boolean Possible(int x){

        for(int i=0; i<x; i++){
            if(chess[x] == chess[i]) return false;
            else if(Math.abs(x - i) == Math.abs(chess[x] - chess[i]))
                return false;
        }
        return true;
    }
}
//https://st-lab.tistory.com/118