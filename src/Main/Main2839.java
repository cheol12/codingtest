package Main;

import java.io.*;
import java.util.*;

public class Main2839 {
    // 수학
    // 다이나믹 프로그래밍
    // 그리디 알고리즘
    public static void main(String args[]) throws IOException{
        // 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면
        // 되는지의 최소값을 구하는 프로그램을 작성하시오. 만들 수 없다면 -1 출력.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int a = 0;  // 설탕 봉지 개수 저장할 객체
        int b = N;

        while(true){
            if(b % 5 == 0){     // 5의 배수면 무조건 최소
                a += b / 5;
                b %= 5;
                break;
            }
            b -= 3;             // 5의 배수가 아닌 상태에서 최소를 유지하려면 3의 개수를 최소화 해야하므로
            a += 1;             // 3짜리 설탕봉지가 1개,2개,3개... 인 경우를 차차 계산해나간다.
            if(b<3) break;
        }
        if(b==0) bw.write(String.valueOf(a));
        else bw.write(String.valueOf("-1"));

        bw.close();
    }
}
// 도움 : https://www.youtube.com/watch?v=uEjckjCGcew