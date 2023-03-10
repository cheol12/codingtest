package programmers;

import java.io.*;
import java.util.*;

class Solution소수찾기 {
    public static int solution(int n) {
        int answer = 0;
        // 소수는 1과 나만 % 결과가 0이 나온다.
        // 다른 걸로 % 연산하면 무조건 0이 아닌 것.
        // 1~n 수 중에서 임의의 수 i가 소수인 지를 파악하고 소수로 판단된 i의 개수 출력
        // i가 소수인지 파악하려면 2~i까지 있는 임의의 j로 i%j 연산을 시행.
        // 2~i에 있는 모든 j가 % 연산 결과값이 0이 아니게 되면 나눠지는게 없으므로 i는 소수가 맞음.
        // 추가로 j는 i/2까지 비교해도 됨.

        for(int i=2; i<=n; i++){    // 범위 지정 1~n 사이에 있는 소수를 구할 것임. 초기값 2부터 시작
            int count = 0;  // i 나눠지는 수의 개수를 표시
            // 2(=i)라면 2(=j)부터 2(=i)까지 , i=3이면 j=2부터 j=3까지, i=4면 j=2부터 j=4까지 증가해가며
            // i로 j를 나눴을 때 2~j까지 나머지가 0이 아닌 수가 있는지 판단. 소수를 구한다
            for(int j=2; j<=i/2; j++){

//                if(j>i/2) break;
                if(i % j == 0) count++; // i가 i보다 작은 j로 나눴을 때 나머지가 0이면 나눠지는 것 = 소수가 아니다

            }
            if(count==0) {      // 나눠지는 것이 없어야 소수이다
                answer++;
                System.out.println(i);
            }

        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(10));

    }
}