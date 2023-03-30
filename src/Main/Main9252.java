package Main;

import java.io.*;
import java.util.*;

public class Main9252 {
    // DP(LCS : 최장 공통 부분 수열)
    // Longest Common Subsequence
    static char[] str1, str2;   // 알파벳 나열
    static long[][] lcs;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        // lcs[][] = 0~i까지 같은 알파벳이 나오는 개수
        lcs = new long[str1.length+1][str2.length+1];

        // 알파벳이 같을 때만 최장 수열에 +1 한다.
        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                // 만약 두 알파벳이 같다면
                if(str1[i-1] == str2[j-1])
                    // 배열상에서 대각선값 +1
                    // 대각선인 이유 : 공통 수열이 하나 더 추가되는 것.
                    // 이전까지 공통 수열의 개수 + 1
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                // 다르면
                else
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        Stack<Character> stack = new Stack<>();

        int len1 = str1.length;
        int len2 = str2.length;
        bw.write(String.valueOf(lcs[len1][len2])+"\n");

        while(len1 >= 1 && len2 >= 1){
            // lcs 2차원 배열상 위의 값과 같으면
            if(lcs[len1][len2] == lcs[len1-1][len2])
                len1--;
            // 왼쪽 값과 같으면
            else if(lcs[len1][len2] == lcs[len1][len2-1])
                len2--;
            // 대각선으로만 같으면, 대각선에 위치한 문자를 출력
            else {
                stack.push(str1[len1 - 1]);
                len1--;
                len2--;
            }
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        bw.close();
    }
}
//https://hoho325.tistory.com/157
//https://soojong.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-9252%EB%B2%88-LCS-2