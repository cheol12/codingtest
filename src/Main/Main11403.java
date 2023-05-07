package Main;

import java.util.*;
import java.io.*;

class Main11403{
    static int N;
    static int[][] G;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        G = new int[N+1][N+1];
        int[][] matrix = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                G[i][j] = Integer.parseInt(token.nextToken());
            }
        }


        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(G[i][k] == 1 && G[k][j] == 1)
                        G[i][j] = 1;
                }

            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                bw.write(G[i][j]+" ");

            }
            bw.write("\n");

        }
        bw.close();
    }
}
