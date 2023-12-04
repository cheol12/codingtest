package programmers;

import java.io.*;
import java.util.StringTokenizer;

class Solution_124나라의숫자{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 10;

        bw.write(solution(n));
        bw.close();
    }

    static String solution(int n) {
        String answer = "";

        int devided = 0;
        int remain = 0;
        int size = 0;
        int tempSum = 0;

        while(n > 0){
            remain = n % 3;
            if(remain == 1){
                answer = answer + "1";
            }
            else if(remain == 2){
                answer = answer + "2";
            }
            else if(remain == 0){
                answer = answer + "4";
            }

            n /= 3;
            if(n % 3 == 0){
                n = n - 1;
            }
        }

        // n=4라면
        // 3으로 나눴을 때
        // 나머지가 1이면 일의 자리가 1
        // 나머지가 2이면 일의 자리가 2
        // 나머지가 0이면 일의 자리가 4
        // 나머지가 1이면
        return answer;
    }
//https://blog.naver.com/lovesm135/223067269977
}