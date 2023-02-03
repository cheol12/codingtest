package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class softeer_meetingroom {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtoken;

//        int N = Integer.parseInt(br.readLine());
        int N;
        int M;
        strtoken = new StringTokenizer(br.readLine());
        N = Integer.parseInt(strtoken.nextToken());
        M = Integer.parseInt(strtoken.nextToken());

        String[] nn = new String[N];
        for(int i=0; i<N; i++){
            nn[i] = br.readLine();
            bw.write(String.valueOf(nn[i])+"\n");
        }


        String[] mm = new String[M];
        for(int i=0; i<M; i++){

        }


        bw.close();
    }
}
