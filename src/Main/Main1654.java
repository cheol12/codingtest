package Main;

import java.io.*;
import java.util.*;

public class Main1654 {

    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        // 이미 보유한 길이가 제각각인 랜선 개수
        K = Integer.parseInt(token.nextToken());
        // 필요한 랜선 개수
        N = Integer.parseInt(token.nextToken());

        int[] kLan = new int[K];

        long max = 0;

        for(int i=0; i<K; i++){
            kLan[i] = Integer.parseInt(br.readLine());
            if(kLan[i] > max) max = kLan[i];
        }

        max++;

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (min + max) / 2;

            long count = 0;

            for(int i=0; i<K; i++){
                count += (kLan[i] / mid);
            }

            if(count < N){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        bw.write(min - 1 + "");
        bw.close();
    }
}
//https://st-lab.tistory.com/269
//이분 탐색에서는 크게 두 가지 방식이 존재한다.
//
//바로 Upper Bound(상한)와 Lower Bound(하한)이다.
//
//상한은 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환한다.
//
//하한은 찾고자 하는 특정 값 이상인 '첫 위치'를 반환한다.
//
// {1,2,2,2,3} 를 예시로 든 경우,
//
// mid = 2 이고
//
// Upper Bound 의 경우 3을 반환
//
// Lower Bound 의 경우 처음 만난 2를 반환
//
// 개수가 중복이 될 때 최대 길이를 찾아야 한다는 것 때문에
//
// Upper Bound를 채택

