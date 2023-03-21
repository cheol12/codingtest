package Main;

import java.util.*;
import java.io.*;

public class Main2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[][] D = new long[N+1][2];

        // D[i][0] => 이진수로 i 자리 숫자인데 0으로 끝나는 것의 개수
        // D[i][1] => 이진수로 i 자리 숫자인데 1으로 끝나는 것의 개수
        D[1][0] = 0;
        D[1][1] = 1;

        for(int i=2; i<D.length; i++){
            D[i][0] = D[i-1][0] + D[i-1][1];    // i 길이에서 끝이 0으로 끝나는 이친수 개수
            D[i][1] = D[i-1][0];            // i 길이에서 끝이 1로 끝나는 이친수 개수
        }

        long[] ex = new long[N+1];

        ex[1] = 1;

        // 직접 노가다하며 이친수 개수 세어보다가 등차 간 관계를 알게 됨.
        // i의 개수 = i-2의 개수 + i-1의 개수
        for(int i=2; i<ex.length; i++){
            ex[i] = ex[i-2] + ex[i-1];
        }

        bw.write(String.valueOf(D[N][0]+D[N][1]));
        bw.write("\n" + String.valueOf(ex[N]));
        bw.close();
    }
}
