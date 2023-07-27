package Main;

import java.io.*;
import java.util.*;

class Main1912{
    static int n;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        sum = new int[n+1];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int answer = arr[1];

        for(int i=1; i<=n; i++){
            sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
            answer = Math.max(sum[i], answer);
        }

        bw.write(answer+"");
        bw.close();
    }
}
//https://steady-coding.tistory.com/180