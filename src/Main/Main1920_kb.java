package Main;

import java.io.*;
import java.util.*;

public class Main1920_kb {
    static int N,M;
    static int[] A, arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int x = Integer.parseInt(token.nextToken());

//            이분탐색 내장함수 활용 : Arrays.binarySerach(A, x);
//            int index = Arrays.binarySearch(A, x);
//            if(index >= 0) bw.write( "1\n");
//            else bw.write("0\n");

            bw.write(binaryS(A, x)+"\n");
        }
        bw.close();
    }

    static int binaryS(int[] arr, int key){

        int startIdx = 0;
        int endIdx = arr.length - 1;

        // 시작인덱스 끝인덱스가 교차하기 전까지 실행
        while(startIdx <= endIdx){
            int midIdx = (startIdx + endIdx)/2;

            if(key < arr[midIdx]){  // 배열 왼쪽
                endIdx = midIdx - 1;
            }
            else if(key > arr[midIdx]){ // 배열 오른쪽
                startIdx = midIdx + 1;
            }
            else{   // 일치
                return 1;
            }
        }
        // 존재하지 않으면
        return 0;
    }
}
