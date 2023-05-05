package Main;

import java.io.*;
import java.util.*;

public class Main17626 {
    static int n;
    static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        n = Integer.parseInt(br.readLine());
        count = new int[n+1];
        count[1] = 1;

        for(int i=2; i<=n; i++){
            // i마다 최소값 갱신
            int min = Integer.MAX_VALUE;

            for(int j=1; j*j<=i; j++){
                // 숫자 (i-1)에서 1의 제곱으로 한 개 추가할 때가 최소인지,
                // 숫자 (i-j의 제곱)에서 j제곱으로 한 개 추가할 때가 최소인지 판단
                min = Math.min(min, count[i-j*j]);
            }
            count[i] = min + 1;
        }
        bw.write(count[n]+"");
        bw.close();
    }
}