package Main;

import java.util.*;
import java.io.*;

class Main9461{
    static long[] P;
    static int T, N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        P = new long[101];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;

        for(int i=4; i<=100; i++){
            P[i] = P[i-2] + P[i-3];
        }

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            bw.write(P[N]+"\n");
        }
        bw.close();
    }
}