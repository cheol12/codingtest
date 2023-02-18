package Main;

import java.io.*;
import java.util.*;

class Main11286 {
    // 문제 제목 : 절댓값 힙
    // 알고리즘 분류 : 자료 구조, 우선순위 큐
    public static void main(String args[]) throws IOException{
        // 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
        // 배열에 정수 x (x ≠ 0)를 넣는다.
        // 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
        // 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고,
        // 그 값을 배열에서 제거한다. (절댓값이 같은 수는 +x, -x 2개가 있으므로 그중 작은 수인 -x출력)
        // 프로그램은 처음에 비어있는 배열에서 시작하게 된다.

        // 출력 : 입력의 0개수만큼 출력, 절댓값 최소인 수 먼저 + 절댓값 같으면 음수부터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 기본적으로 작은 수가 먼저.
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) ->{

            // 절댓값 작은 데이터 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절댓값이 같은 경우 음수 우선
            if(first_abs == second_abs){
                // 절댓값이 같은 경우 음수 우선 정렬 = 오름차순 정렬
                return o1 > o2 ? 1 : -1;
            }
            // o1>o2 참이면 return 1 = true = 오른쪽 = o2 = 더 작은 수 출력,
            // 거짓이면 return -1 = false = 왼쪽 = o1 = 더 큰 수 출력


            //절댓값이 다른 경우, 절댓 값이 작은 수 기준으로 정렬한다.
            return first_abs - second_abs;
            // -1 = false = 왼쪽 = o1
            // +1 = true = 오른쪽 = o2
        });

        for(int i=0; i<N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(myQueue.isEmpty()){
                    bw.write(String.valueOf("0\n"));
                }else{
                    bw.write(String.valueOf(myQueue.poll()+"\n"));
                }
            }else{
                myQueue.add(request);
            }
        }

        bw.close();
    }
}
