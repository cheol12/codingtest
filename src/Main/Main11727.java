package Main;

import java.util.*;
import java.io.*;

class Main11727{
    static int n;
    static long[] tile;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());

        tile = new long[1001];
        tile[1] = 1;
        tile[2] = 3;
        tile[3] = 5;
        tile[4] = 11;


        for(int i=3; i<=n; i++){
            tile[i] = tile[i-1] +  2*tile[i-2];
        }

        bw.write(tile[n]%10007+"");
        bw.close();
    }
}