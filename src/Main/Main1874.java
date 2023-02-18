package Main;

import java.io.*;
import java.util.*;

public class Main1874 {
    // 문제 제목 : 스택 수열
    // 알고리즘 분류 : 자료 구조, 스택
    public static void main(String args[]) throws IOException{
        // 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와
        // 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
        // 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록
        // 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를
        // 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

        // 입력 : 첫 줄에 n을 입력하면 1~n까지 숫자 생성. 그 다음 1~n 사이의 수 중 하나를 골라 n개의 각 줄마다 하나씩 입력하여 수열 만들기.
        // 출력 : 그 다음으로 입력한 수열을 push, pop 연산으로 만들 수 있으면 각 자리에 +(push), -(pop)으로 표현.
        //       없으면 No 출력 (단, push 순서는 오름차순).
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            // 만들 수열을 배열로 입력
            A[i] = Integer.parseInt(br.readLine());
        }

        // 후입선출. 조건: push 순서는 무조건 오름차순
        Stack<Integer> stack = new Stack<>();

        // 입력된 수열을 만들기 위한 객체. 입력된 각 숫자마다 비교. 1부터 시작할 오름차순 숫자
        int num = 1;
        boolean result = true;


        StringBuffer bf = new StringBuffer();    // +, - 저장할 객체

        for(int i=0; i<A.length; i++){
            int suyeol = A[i];    // 입력한 수열 속 i번째 숫자 저장할 객체
            if(suyeol >= num){    // 배열 속 i번째 숫자가 num보다 크거나 같다면
                while(suyeol >= num){    // 같아질 때까지 반복
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                int n = stack.pop();
                if(n > suyeol){
                    bw.write("NO");
                    result = false;
                    break;
                }
                bf.append("-\n");
            }

        }

        if(result){
            bw.write(bf.toString());
        }
        bw.close();

    }
}
