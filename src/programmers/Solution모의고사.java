package programmers;

import java.util.*;

public class Solution모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(solution(answers));
    }

    static List<Integer> solution(int[] answers) {

        // key = 사람 번호, value = 맞힌 개수 인 Map 생성.
        Map<Integer, Integer> answerMap = new HashMap<>();

        // 답을 기입할 List 생성
        List<Integer> answerList = new ArrayList<>();

        int max = -1;

        for(int i=1; i<=3; i++){
            int[] supoza = new int[]{};
            // 1번, 2번, 3번 수포자가 찍는 방식 설정
            switch(i){
                case 1:
                    supoza = new int[]{1, 2, 3, 4, 5};
                    break;
                case 2:
                    supoza = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
                    break;
                case 3:
                    supoza = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
                    break;
            }

            // 사람이 맞힌 개수 계산
            int count = solve(supoza, answers);
            // 수포자 1,2,3 중 가장 많이 맞춘 개수
            max = Math.max(max, count);
            answerMap.put(i, count);
        }

        // 맞힌 개수 == max 인 사람의 번호를 판단하기 위해
        // keySet으로 value 값 판단
        for(int personNum : answerMap.keySet()){
            if(answerMap.get(personNum) == max){
                answerList.add(personNum);
            }
        }

        // 2명 이상이면 오름차순 정렬
        if(answerList.size() > 1) Collections.sort(answerList);

        return answerList;
    }

    static int solve(int[] supoza, int[] answers){
        // 큐 순환하면서 반복 진행
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;

        for(int temp : supoza){
            // supoza 가 기입한 정답을 q에 입력
            q.offer(temp);
        }

        //
        for(int answer : answers){
            // supozaInput = 매개변수로 입력된 supoza가 찍은 정답들
            int supozaInput = q.poll();
            if(answer == supozaInput) count++;
            // 계속적인 패턴을 위해 다시 새로 입력
            q.offer(supozaInput);
        }
        return count;
    }
}
