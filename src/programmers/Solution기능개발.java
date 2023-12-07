package programmers;

import java.util.*;

public class Solution기능개발 {
    public static void main(String[] args) {
//        int[] progresses = {95, 90, 99, 99, 80, 99, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 60, 63, 62, 59, 55};
//        int[] speeds = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    static int[] solution(int[] progresses, int[] speeds) {
        long beforeTime = System.nanoTime(); //코드 실행 전에 시간 받아오기

        int[] answer = {};

        List<Integer> answerList = new ArrayList<>();
        int size = speeds.length;
        Queue<Integer> q;

        // 배열 안에서 인덱스가 작은 것부터 100이 넘는지 판단한다.
        for(int i=0; i<size; i++){
            if(progresses[i] >= 100) continue;

            // progresses[i] = 판단하는 수가 100이 넘을 때까지 모두의 작업을 진행
            while(progresses[i] < 100){
                for(int j=0; j<size; j++){
                    if(progresses[j] >= 100) continue;
                    progresses[j] += speeds[j];
                }
            }

            // 작업을 거치고 100이 넘었으면 연속된 인덱스이자 함께 완료된 배열 원소들을 큐에 넣는다.
            q = new ArrayDeque<>();
            int j = i;
            q.offer(j);
            while(j < progresses.length-1 && progresses[++j] >= 100){
                q.offer(j);
            }

            // 한 번에 배포되는 작업들의 개수를 알기 위해 큐 사이즈 반환
            System.out.println(q.toString());
            answerList.add(q.size());
        }

        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        // 풀이 끝

        long afterTime = System.nanoTime(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime) / 1000; // 실행 시간 계산
        System.out.println("실행시간(ms) : "+secDiffTime);

        return answer;
    }
}
