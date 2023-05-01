package Main;

import java.io.*;
import java.util.*;

public class Main9095 {
    static int T,n;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        count = new int[11];

        count[1] = 1;
        count[2] = 2;
        count[3] = 4;
        for(int i=4; i<11; i++){
            count[i] = count[i-1] + count[i-2] + count[i-3];
        }

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            bw.write(count[n]+"\n");
        }
        bw.close();
    }
}