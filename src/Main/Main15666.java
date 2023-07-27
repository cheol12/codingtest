package Main;

import java.io.*;
import java.util.*;

public class Main15666 {
    static int[] arr;
    static int[] print;
    static int N,M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        print = new int[M];

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        DFS(0, 0);
        bw.close();
    }

    static void DFS(int start, int th)throws IOException{
        if(th == M){
            for(int i : print){
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        int before = 0;
        for(int i=start; i<N; i++){
            if(before == arr[i]) continue;
//            if((th >= 1) && (print[th-1] > arr[i]))
//                continue;
            before = arr[i];
            print[th] = arr[i];
            DFS(i, th+1);
        }
    }
}
