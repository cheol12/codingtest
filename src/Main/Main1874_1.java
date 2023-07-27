package Main;

import java.io.*;
import java.util.*;

public class Main1874_1 {
    static int n;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());;
        }

        sb = new StringBuilder();

        if(action()) bw.write(sb+"");
        else bw.write("NO");

        bw.close();
    }

    static boolean action() throws IOException{
        int num = 1;    // 처음에 1을 push한다
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<=n; i++){
            int now = arr[i];
            if(now >= num) {
                while(now >= num){
                    stack.push(num);
                    sb.append("+\n");
                    num++;
                }
                stack.pop();
                sb.append("-\n");
            }
            else{
                int temp = stack.pop();
                if(now < temp){
                    return false;
                }
                sb.append("-\n");
            }
        }
        return true;
    }
}