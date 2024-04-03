package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution큰수만들기 {
    public static void main(String[] args) {

        System.out.println(solution("4177252841", 4));
    }

    static String solution(String number, int k) {
//        String answer = "";

        // 시간초과 실패 : 83.3점
//        PriorityQueue<Integer> pq;
//
//        int startIdx = 0;
//        int endIdx = k;
//
//        // number객체를 인덱스 0부터 length() - k 까지 자르고 가장 큰 것을 고르기
//        while(answer.length() < number.length() - k){
//
//            pq = new PriorityQueue<>(Collections.reverseOrder());
//
//            for(int i=startIdx; i<=endIdx; i++){
//                int temp = Integer.parseInt(number.substring(i, i+1));
//                pq.offer(temp);
//            }
//
//            for(int i=startIdx; i<=endIdx; i++){
//                int temp = Integer.parseInt(number.substring(i, i+1));
//                if(temp == pq.peek()){
//                    answer += pq.poll();
//                    startIdx = i+1;
//                    endIdx++;
//                    break;
//                }
//            }
//        }


        // StringBuilder 로 해야 시간초과 해결됨.
        StringBuilder answer = new StringBuilder();

        int len = number.length() - k; // 6자리

        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수
        int start = 0;

        for(int i =0; i<len; i++){
            int max = 0;

            for(int j = start; j <= i + k; j++){
                // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기
                if(number.charAt(j) - '0' > max){   // char형을 int형으로 변환하기
                    max = number.charAt(j) - '0';   // number의 j번째가 크면 그걸로 바꾸기
                    start=j+1;
                }
            }
            // 가장 큰 문자를 answer에 넣어주기
            answer.append(max);
        }

        return answer.toString();
    }
}
