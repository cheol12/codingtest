package Main;

import java.util.*;
import java.io.*;

public class Main11720 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

//        int N = Integer.parseInt(br.readLine());
//        String M = br.readLine();
//
//        String[] a = M.split("");
//        int[] b = new int[a.length];
//        int c = 0;
//        for(int i=0; i<a.length; i++){
//            b[i] = Integer.parseInt(a[i]);
//            bw.write(a[i]+"\n");
//            c += b[i];
//        }
//        bw.write(String.valueOf(c));
//        bw.close();

        // 유튜브 하루코딩 풀이
        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();
        char[] L = M.toCharArray();

        int sum = 0;
        for(int i=0; i<L.length; i++){
            sum += L[i] - '0';   // - '0' : 문자를 int형으로 바꾸면서 연산하는 것.
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
