package Main;

import java.io.*;
import java.util.*;

public class Main1976_kb {
    static int N,M;
    static int[][] parent;
    static int[] search;
    static ArrayList<Integer>[] arrlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1][N+1];
        search = new int[M];

        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                parent[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            search[i] = Integer.parseInt(token.nextToken());
        }

//        union();
    }

    static void union(int x, int y){

        x = find(x);
        y = find(y);
        for(int i=0; i<M; i++){
            search[i] = find(search[i]);
        }

//        if(x != y) parent[y] = x;
//        else parent[x] = y;
    }

    static int find(int x){
//        if(x == parent[x]) return x;
//        return parent[x] = find(parent[x]);
        return 1;
    }
}
