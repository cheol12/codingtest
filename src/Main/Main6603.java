package Main;

import java.io.*;
import java.util.*;

class Main6603{
    static int[] S;
    static int[] print;
    static boolean[] visited;
    static int k;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        while(true){
            String temp = br.readLine();
            if(temp.equals("0")) break;
            token = new StringTokenizer(temp);
            k = Integer.parseInt(token.nextToken());
            S = new int[k];
            print = new int[6];
            visited = new boolean[k];

            for(int i=0; i<k; i++){
                S[i] = Integer.parseInt(token.nextToken());
            }
            DFS(0, 0);
            System.out.println();
        }
    }

    static void DFS(int start, int th) throws IOException{
        if(th == 6){
            for(int i=0; i<6; i++){
                System.out.print(print[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<k; i++){
            if(visited[i]) continue;
            visited[i] = true;
            print[th] = S[i];
            DFS(i+1, th+1);
            visited[i] = false;
        }
    }
}