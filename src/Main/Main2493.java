package Main;

import java.io.*;
import java.util.*;

class Main2493{
    static class Top{
        int num, height;
        Top(int num, int height){
            this.num = num;
            this.height = height;
        }
    }
    static int N;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N =  Integer.parseInt(br.readLine());
        arr = new int[N+1];
        result = new int[N+1];
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int temp = Integer.parseInt(token.nextToken());

            while(!stack.isEmpty()){
                if(temp <= stack.peek().height){
                    bw.write(stack.peek().num + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) bw.write("0 ");
            stack.push(new Top(i, temp));
        }

        bw.close();
    }
}
//https://1-7171771.tistory.com/71