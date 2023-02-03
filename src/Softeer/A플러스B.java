package Softeer;

import java.util.*;
import java.io.*;

public class A플러스B {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());
        int c[] = new int[T];

        for(int i=0; i<T; i++){
            int A,B;
            token = new StringTokenizer(br.readLine());
            A = Integer.parseInt(token.nextToken());
            B = Integer.parseInt(token.nextToken());
            c[i] = A + B;

            bw.write("Case #" + String.valueOf(i+1) + ": " + String.valueOf(c[i]) + "\n");
        }

        bw.close();
    }
}
