package programmers;

import java.io.*;

public class Solution_예상대진표 {

    public static void main(String[] args) throws IOException {

        System.out.println(solution(8,4,7));
    }

    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        // 게임 참가자 수는 n이고
        // 이 때 첫 라운드 게임 조는 n/2이다.
        // a와 b 모두 현재의 조를 가리키도록 한다.

        while(a != b){
            answer ++;
            a = nextTeam(a);
            b = nextTeam(b);
        }

        // 다음 조가 같은 조면 멈춘다.

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    static int nextTeam(int x){
        if(x % 2 == 0) x /= 2;
        else x = x/2 + 1;
        return x;
    }
}
