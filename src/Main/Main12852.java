package Main;

import java.io.*;
import java.util.*;

class Main12852{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[N+1];
        int[] before = new int[N+1];
        arr[1] = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=2; i<=N; i++){
            arr[i] = arr[i-1] + 1;
            before[i] = i-1;
            if(i % 3 == 0 && (arr[i] > arr[i/3] + 1)){
                arr[i] = arr[i/3] + 1;
                before[i] = i/3;
            }
            if(i % 2 == 0 && (arr[i] > arr[i/2] + 1)){
                arr[i] = arr[i/2] + 1;
                before[i] = i/2;
            }

        }

        bw.write(arr[N]+"\n");
        while(N > 0){
            sb.append(N + " ");
            N = before[N];
        }
        bw.write(sb+"");
        bw.close();
    }
}
//https://c-king.tistory.com/entry/%EC%9E%90%EB%B0%94%EB%B0%B1%EC%A4%80-12852-1%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-2