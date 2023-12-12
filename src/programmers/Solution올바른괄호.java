package programmers;

import java.util.*;

public class Solution올바른괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }
    static boolean solution(String s) {
        boolean answer = true;
        long beforeTime = System.nanoTime(); //코드 실행 전에 시간 받아오기

        // 큐 방식 정답
        Queue<Character> q = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') q.offer('(');
            else if(q.poll() == null) return false;
        }

        if(!q.isEmpty()) answer = false;
        //

        // 스택 방식 정답
//        Stack<Character> stack = new Stack<>();
//        try{
//            for(int i=0; i<s.length(); i++){
//                if(s.charAt(i) == '(') stack.push('(');
//                else stack.pop();
//            }
//        }catch(Exception o){
//            return false;
//        }
//        if(!stack.isEmpty()) answer = false;
        //

        long afterTime = System.nanoTime(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime) / 1000; // 실행 시간 계산
        System.out.println("실행시간(ms) : " + secDiffTime);

        return answer;
    }
}
