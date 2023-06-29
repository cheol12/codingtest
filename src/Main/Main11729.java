package Main;

import java.io.*;
import java.util.*;

class Main11729{
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        N = Integer.parseInt(br.readLine());

        bw.write((int)Math.pow(2,N) - 1 + "\n");
        Hanoi(N, 1, 2, 3);

        bw.close();
    }
    static void Hanoi(int N, int start, int mid, int to) throws IOException{
        if(N == 1) {
            bw.write(start + " " + to + "\n");
            return;
        }
        
        Hanoi(N-1, start, to, mid); // start에 위치한 N-1개의 탑들을 mid로 옮긴다.
        bw.write(start + " " + to + "\n");

        Hanoi(N-1, mid, start, to); // mid에 위치한 N-1개의 탑들을 to로 옮긴다.
    }
}
//https://st-lab.tistory.com/96
