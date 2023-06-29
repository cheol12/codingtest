package Main;

import java.io.*;
import java.util.*;

class Main1074{
    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        int size = (int)Math.pow(2,N);

        DFS(size, r, c);

        bw.write(count+"");
        bw.close();
    }

    // N=3이라면, size = 8, (size=2의 N제곱)
    // r,c는 0~7까지 존재.
    static void DFS(int size, int r, int c){
        if(size == 1) return;

        if(r < size/2 && c < size/2){
            DFS(size/2, r, c);
        }
        else if(r < size/2 && c >= size/2){
            count += size * size / 4;
            DFS(size/2, r, c - size/2);
        }
        else if(r >= size/2 && c < size/2){
            count += size * size / 2;
            DFS(size/2, r - size/2, c);
        }
        else{
            count += size * size / 4 * 3;
            DFS(size/2, r - size/2, c - size/2);
        }
    }
}
//https://wiselog.tistory.com/133