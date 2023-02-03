package Softeer;

import java.io.*;
import java.util.StringTokenizer;

public class distance_driven {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtoken;

        strtoken = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(strtoken.nextToken());
        int B = Integer.parseInt(strtoken.nextToken());

        Object C = "";
        if(A>B){
            C = A;
        }else if(B>A){
            C = B;
        }else if(A==B){
            C = "same";
        }
        bw.write(String.valueOf(C));
        bw.close();
    }
}
