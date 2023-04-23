package Main;

import java.util.*;
import java.io.*;

public class Main12100 {
    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int moveCount=1; moveCount<=5; moveCount++){

        }

        bw.close();
    }
}
