package Main;

import java.util.*;
import java.io.*;

class Main11501{
    static int T, N;
    static int[] stock;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        T = Integer.parseInt(br.readLine());

        // 1. 주식 하나 구매
        // 2. 보유 주식 판매
        // 3. X
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            stock = new int[N];
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                stock[j] = Integer.parseInt(token.nextToken());
            }

            // 마지막 케이스를 통해 상승세마다 합을 구해야겠다고 생각.

            // 하나의 상승세 구간 합
            int beneSum = 0;

            // 상승세의 마지막 지점
            int benePoint = stock[N-1];

            // 상승세 주가 목록
            List<Integer> buyList = new ArrayList<>();

            for(int j=N-2; j>=0; j--){

                // 상승세 유지 중이라면
                if(stock[j] <= benePoint){
                    buyList.add(stock[j]);
                }
                
                // else if 하지 않는 이유 : 상승세 유지 중 && j = 0 인 경우가 있기 때문
                // 상승세가 아니거나 마지막 비교일 경우
                if(stock[j] > benePoint || j == 0){
                    // 상승세의 마지막 지점을 익절 시점으로 하고, 이익을 모두 합한다
                    for(int temp : buyList){
                        beneSum += benePoint - temp;
                    }
                    // 다음 상승세의 마지막으로 지정
                    benePoint = stock[j];
                    // 다음 상승세 판단을 위해 비우기
                    buyList.clear();
                }
            }
            bw.write(beneSum + "\n");
        }
        bw.close();
    }
}
//https://tussle.tistory.com/936