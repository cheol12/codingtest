package programmers;

import java.util.Arrays;

public class Solution_구명보트 {

    public static void main(String[] args){
        int[] people = {70, 80, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        // 몸무게가 limit/2 초과인 사람 수
        int bigCount = 0;

        for(int i=0; i<people.length; i++){
            if(people[i] > limit/2){
                bigCount++;
            }
        }

        // limit/2 초과인 사람은 두당 1번만 가능
        answer += bigCount;

        // bigCount 제외하고 남은 사람
        int leaveCount = people.length - bigCount;

        answer += leaveCount/2;

        answer += leaveCount%2;

        return answer;
    }
}