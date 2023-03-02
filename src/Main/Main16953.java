package Main;

import java.io.*;
import java.util.*;

public class Main16953 {
    // 그래프 이론
    // 그리디 알고리즘
    // 그래프 탐색
    // 너비 우선 탐색
    public static void main(String args[]) throws IOException{

        // 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음 두 가지.
        // 2를 곱한다.
        // 1을 수의 가장 오른쪽에 추가한다.
        // A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

        // 입력 : 첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
        // 출력 : A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다.
        // 만들 수 없는 경우에는 -1을 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        int count = 0;  // 연산 횟수 저장 객체

        // 마지막이 1이면 1없애기, 2의 배수면 2로 나누기, A = B 안되면 -1 바로 출력하는 반복문
        while(A != B){

            // (B의 1의 자리가 1 or B가 2의 배수)인 것도 아닌 경우, 혹은 B가 A보다 작아졌으면
            if( !((B % 10 == 1) || (B % 2 == 0)) || (B < A) ){
                count = -2;     // count를 -1로 출력하기 위해 -2로 설정,
                break;          // 반복문 break.

            }else if( B % 2 == 0 ){     // B가 2의 배수이면
                B /= 2;                 // 연산 실행
                count += 1;             // 연산 횟수 +1

            }else if( B % 10 == 1 ){    // B의 1의 자리가 1
                B /= 10;                // 연산 실행
                count += 1;             // 연산 횟수 +1
            }
        }

        bw.write(String.valueOf(count + 1));    // 연산 최소 횟수에 1 더한 값 출력
        bw.close();
    }

}

