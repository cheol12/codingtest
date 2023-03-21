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

        // 기준1) N명 중 임의의 2명이 서로에게 선물을 주는 경우,
        // -> 2명은 계산에서 제외되므로 N-2명이 선물을 나누는 경우의 수를 구하는 것과 같다.
        // ( = present[N-2] )
        // 이처럼 2명이 서로에게 선물을 주는 경우 자체가 N-1번 발생할 수 있으므로
        // present[N-2] * (N-1) 로 표현 가능.

        // 기준2) N명 중 서로에게 선물을 주는 경우가 없을 때,
        // -> 만약 N=5일 때, 4번이 5번에게 선물을 주었다고 가정해보자.
        // 선물 받은 5번의 자리는 제외하고 나머지 4명의 선물을 채워야한다.
        // 이때, 선물을 준 4번의 자리는 어차피 자기 자신인 4번의 선물도 올 수 없고 +
        // 기준1)에서 구한 경우를 제외하기 위해 5번의 선물도 올 수 없다.
        // 그렇다면 4번 자리를 5번으로 대체하여 생각하는 것도 가능하다.
        // 이는 이미 선물받은 1명을 아예 계산에서 제외할 수 있다는 것을 보여주고
        // N-1명이 선물을 나누는 경우의 수를 구하는 꼴이 된다. ( = present[N-1] )
        // 그리고 N명 중 임의의 a번의 선물을 받을 수 있는 b의 경우의 수가 N-1이므로
        // present[N-1] * (N-1) 로 표현 가능.

        // 두 가지 기준을 더하면 ( present[N-2] + present[N-1] ) * (N-1)

        bw.write(String.valueOf(present[N]));
        bw.close();
    }
}
//https://velog.io/@qwerty1434/%EB%B0%B1%EC%A4%80-1947%EB%B2%88-%EC%84%A0%EB%AC%BC-%EC%A0%84%EB%8B%AC