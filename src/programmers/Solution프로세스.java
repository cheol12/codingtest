package programmers;

import java.util.*;

public class Solution프로세스 {

    static class ProcessQ{
        int idx, pry;
        ProcessQ(int idx, int pry){
            this.idx = idx;
            this.pry = pry;
        }
    }
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;

        List<Integer> completeList = new ArrayList<>();

        Queue<ProcessQ> q = new ArrayDeque<>();

        for(int i=0; i<priorities.length; i++)
            q.offer(new ProcessQ(i, priorities[i]));

        // answerList.get(location) != null
        while(!q.isEmpty()){
            ProcessQ takeOutQ = q.poll();
            boolean check = false;
            for(ProcessQ tempQ : q){
                if(tempQ.pry > takeOutQ.pry){
                    q.offer(takeOutQ);
                    // 우선순위가 큰 것이 있다
                    check = true;
                    break;
                }
            }

            // 나보다 우선순위가 큰 것이 없다면
            if(!check) {
                completeList.add(takeOutQ.idx);
                if(takeOutQ.idx == location) break;
            }
        }

        answer = completeList.size();
        return answer;
    }
}
