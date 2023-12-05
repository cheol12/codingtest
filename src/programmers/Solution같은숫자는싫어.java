package programmers;

import java.util.*;

public class Solution같은숫자는싫어 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
    }

    static int[] solution(int []arr) {

        long beforeTime = System.nanoTime(); //코드 실행 전에 시간 받아오기
        int[] answer = {};

        // 풀이 1 : 스택 방식
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }
        answer = new int[stack.size()];

        for(int i=0; i<stack.size(); i++){
            answer[i] = stack.get(i);
        }

//        풀이 2 : 더 빠른 방식 = 이전 수를 새로운 객체에 저장하며 비교한다.
//        List<Integer> list = new ArrayList<>();
//        int preNum = -1;
//        for(int temp : arr){
//            if(temp != preNum)
//                list.add(temp);
//            preNum = temp;
//        }
//
//        answer = new int[list.size()];
//        for(int i=0; i<list.size(); i++)
//            answer[i] = list.get(i).intValue();

        long afterTime = System.nanoTime(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
        System.out.println(Arrays.toString(answer));
        System.out.println("시간차이(ms) : "+secDiffTime);

        return answer;
    }
}
