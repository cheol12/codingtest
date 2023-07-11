package Main;

import java.util.Stack;
import java.io.*;

class Main17608{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++){
            int stick = Integer.parseInt(br.readLine());
            stack.push(stick);
        }

        int right = stack.pop();
        int answer = 1;    // 맨 오른쪽 한 개는 무조건 보인다
        int temp;   // 보이는 기준 높이를 갱신
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(right < temp) {
                answer++;
                right = temp;
            }
        }

        bw.write(answer+"");
        bw.close();
    }
}