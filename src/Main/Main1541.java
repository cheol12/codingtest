package Main;

import java.io.*;
import java.util.*;

class Main1541 {
    static int answer = 0;

    public static void main(String args[]) throws IOException{
//        세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
//        그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
//        괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
//        token = new StringTokenizer(br.readLine());

        String a = br.readLine();
        int sum = 0;
        String b[] = a.split("-");

        // 1. 더한 걸 배열객체 b에 대체하기
//        for(int i=0; i<b.length; i++){
//            String c[] = b[i].split("\\+");
//            int sum1 = 0;
//            for(int j=0; j<c.length; j++){
//                sum1 += Integer.parseInt(c[j]);
//            }
//            b[i] = String.valueOf(sum1);
//        }
//        sum = Integer.parseInt(b[0]);
//
//        for(int i=1; i<b.length; i++){
//            sum -= Integer.parseInt(b[i]);
//        }


        // 2. 새로운 배열객체에 더한 값 넣기
//        int[] d = new int[b.length];
//
//        for(int i=0; i<b.length; i++){
//            String[] c = b[i].split("\\+");
//            for(int j=0; j<c.length; j++){
//                d[i] += Integer.parseInt(c[j]);
//            }
//            if(i==0) sum += d[i];
//            else if(i>0) sum -= d[i];
//        }

        // 3. 하루코딩 풀이

            for(int i=0; i<b.length; i++){
                int temp = mysum(b[i]);
                if(i==0) answer += temp;
                else answer -= temp;
            }
            bw.write(String.valueOf(answer));
        bw.write(String.valueOf(sum));
        bw.close();
    }

    // 하루코딩 풀이
    private static int mysum(String f){
        int sum2 = 0;
        String[] temp = f.split("\\+");
        for(int i=0; i<temp.length; i++){
            sum2 += Integer.parseInt(temp[i]);
        }
        return sum2;
    }
}
