package Main;

import java.io.*;
import java.util.*;

class Main2018 {
    // 문제 제목 : 수들의 합 5
    // 알고리즘 분류 : 수학, 두 포인터
    public static void main(String args[]) throws IOException{
        // 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의
        // 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
        // 예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
        // N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.


        // S[i] = S[i-1] + A[i]
        // A배열 안에서 start index(0부터) 설정, end index(0부터) 설정
        // start인덱스와 end인덱스 사이의 값들을 더하며 sum최신화
        //
        // sum이 N보다 작으면 end인덱스 증가,
        // sum이 N보다 크면 start인덱스 증가,
        // sum이 N과 같으면 count++
        // count = 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 1;   // 괄호값이 들어있는 index값 구하기
        int end = 1;
        int sum = 1;    // N과 비교할 객체 sum

        while(start <= N){
            if(sum == N){
                count++;
                end++;
                sum += end;
            }else if(sum<N){
                end++;
                sum += end;
            }else{
                sum -= start;
                start++;
            }
        }

        bw.write(String.valueOf(count));
        bw.close();

    }
}
