package Main;

import java.io.*;
import java.util.*;

public class Main11399 {
    static int N;
    static int[] P,time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        time = new int[N];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(P);
        time[0] = P[0];
        int sum = time[0];

        for(int i=1; i<N; i++){
            time[i] = time[i-1] + P[i];
            sum += time[i];
        }

        bw.write(Arrays.toString(time)+" "+sum);
        bw.close();
    }
}