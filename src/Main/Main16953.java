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

        // 출력 : A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다.
        // 만들 수 없는 경우에는 -1을 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        // 마지막이 1이면 1없애기, 2의 배수면 2로 나누기, 아니면(=else=홀수면) -1 바로 출력

        String c = String.valueOf(B);
        Integer e = Integer.parseInt(c);

        while(A != Integer.parseInt(c)) {
            if (c.charAt(c.length() - 1) == '1') {
                c = c.substring(0, c.length() - 1);
            }
            else if(Integer.parseInt(c) % 2 == 0){
                c = String.valueOf(Integer.parseInt(c) / 2);
            }
            else{
                bw.write("-1");
            }
        }
        char d[] = c.toCharArray();

        int count = 0;
        if(d[d.length-1] == '1'){
            ;
        }


        bw.write(Arrays.toString(d));

        bw.close();
    }

}

