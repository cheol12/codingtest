package Main;

import java.util.*;
import java.io.*;

class Main11726{
    static int N;
    static int[] tile;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        tile = new int[1001];
        tile[1] = 1;
        tile[2] = 2;
        for(int i=3; i<=N; i++){
            tile[i] = (tile[i-2] + tile[i-1]) % 10007;
        }
        bw.write(String.valueOf(tile[N]));
        bw.close();
    }
}