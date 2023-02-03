package Softeer;

import java.io.*;
import java.util.*;

public class workingtime {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer strtoken;

        int sum1 = 0;

        String[] total;
        for(int i=0; i<5; i++){
            strtoken = new StringTokenizer(br.readLine());
            String A = strtoken.nextToken();
            String B = strtoken.nextToken();


            for(int j=0; j<2; j++){
                String[] aa = A.split(":");
                String[] bb = B.split(":");
                if(j==0){
                    sum1 += 60*(Integer.parseInt(bb[j]) - Integer.parseInt(aa[j]));
                }else{
                    sum1 += Integer.parseInt(bb[j]) - Integer.parseInt(aa[j]);
                }
            }
        }
        System.out.println(sum1);
        bw.write(sum1);
        bw.close();
    }
}
