package Main;

import java.util.*;
import java.io.*;

public class Main1947 {
    static int N;
    static long[] present;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        present = new long[1000001];
        present[1] = 0;
        present[2] = 1;

        for(int i=3; i<=N; i++){
            present[i] = (present[i-2]+present[i-1])*(i-1) % 1000000000;
        }

        // present[i] = ( present[i-2]+present[i-1] ) * (i-1)
        // 점화식이 위와 같은 이유
        // : N명이 선물을 나누는 경우의 수를 구하는 과정에서 두 가지 기준으로 나눈다.

        // 기준1) present[i]에서 임의의 '한 쌍이 서로의 선물을 받을' 때,
        // 해당 2명은 더 이상 선물을 주고 받을 수 없기 때문에
        // 2명을 계산에서 제외한 것과 같다 = present[i-2]
        // '한 쌍'이 될 수 있는 경우의 수 = i-1
        // 기준1)은 => present[i-2] * (i-1)

        // 기준2) 임의의 'a가' 준 사람과, 'a에게' 준 사람이 다른 경우
        // 예시 : a가 b에게 선물을 주었다고 가정해보자.
        // 이때, '기준1 : 한 쌍이 서로의 선물을 받은' 경우를 제외하려면
        // b는 a에게 선물을 줄 수 없다.
        // 이 상황에서 어찌됐든 a는 누군가에게 선물을 받아야 하고,
        // b는 누군가에게 선물을 주어야한다.
        // 그렇다면 여기서 a와 b를 하나의 개체로 묶어서 생각하면 a와 b를
        // 제외한 누군가에게 정상적으로 선물을 주는 것도 받는 것도 가능하다.
        // 이는 계산에서 a,b 2명을 없애고 새로운 1명을 추가한 것과 같기 때문에,
        // present[i-1]와 같다.
        // + i명 중, a에게 선물을 받는 b가 될 수 있는 경우의 수 = i-1
        // present[i-1] * (i-1) 로 표현 가능.

        // 두 가지 기준을 더하면 ( present[i-2] + present[i-1] ) * (i-1)

        bw.write(String.valueOf(present[N]));
        bw.close();
    }
}
//https://velog.io/@qwerty1434/%EB%B0%B1%EC%A4%80-1947%EB%B2%88-%EC%84%A0%EB%AC%BC-%EC%A0%84%EB%8B%AC