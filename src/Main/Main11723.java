package Main;

import java.io.*;
import java.util.*;

public class Main11723 {
    static int M;
    static boolean[] visited;
    static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int S = 0;
        M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            token = new StringTokenizer(br.readLine());
            String oper = token.nextToken();
            if(oper.equals("all")){
                S = (1 << 21) - 1;
            }else if(oper.equals("empty")){
                S = 0;
            }else{
                int num = Integer.parseInt(token.nextToken());
                if(oper.equals("add")) S |= (1 << num); // num번째 비트가 0이든 1이든 = 1로 만들기
                else if(oper.equals("remove")) S &= ~(1 << num);    // num번째 비트가 0이든 1이든 = 0으로 만들기
                else if(oper.equals("check")) bw.write(((S & (1 << num)) == 0 ? 0 : 1) + "\n");
                else if(oper.equals("toggle")) S ^= (1 << num);
            }
        }
        bw.close();
    }

}
//https://myeongju00.tistory.com/31#article-5-0-1--%EB%B9%84%ED%8A%B8%EB%9E%91-%EB%B9%84%ED%8A%B8%EB%A7%88%EC%8A%A4%ED%82%B9-%EA%B0%9C%EB%85%90
//주의) 20자리의 이진수가 있을 때, 각 비트의 자리수는 0~19이므로 -1을 해주어서 범위를 맞춰주어야한다!