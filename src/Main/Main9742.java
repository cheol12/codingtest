package Main;

import java.io.*;
import java.util.*;

class Main9742{

    static char[] chars;
    static int totalCount, num;
    static boolean[] visited;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        String temp;

        while((temp = br.readLine()) != null){
            token = new StringTokenizer(temp);
            String str = token.nextToken();
            num = Integer.parseInt(token.nextToken());

            totalCount = 0;
            chars = new char[str.length()];
            visited = new boolean[str.length()];
            
            Permutation(str, 0);
            if(totalCount < num) answer = "No permutation";
            System.out.println(str + " " + num + " = " + answer);
//            else bw.write(str + " " + num + " = " + answer);
            // 테스트 케이스 개수가 없는 문제의 특성으로 인해 bw.write() 사용불가
        }

    }

    static void Permutation(String str, int count){

        if(count == str.length()){
            totalCount++;
            if(totalCount == num)
                answer = String.valueOf(chars);
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            chars[count] = str.charAt(i);
            Permutation(str, count + 1);
            visited[i] = false;
        }
    }
}