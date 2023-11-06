package Main;

import java.io.*;
import java.util.*;

class Main1931_1{
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];


        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) ->
                (o1[1] != o2[1]) ? o1[1] - o2[1] : o1[0] - o2[0]);

        int count = 1;
        int endTime = arr[1][1];

        // 제일 빨리 끝나면서 이전과 겹치지 않는것
        for(int i=2; i<=N; i++){
            if(arr[i][0] >= endTime){
                endTime = arr[i][1];
                count += 1;
            }

        }
        bw.write(count+"");
        bw.close();
    }
}