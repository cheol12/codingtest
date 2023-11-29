package programmers;

import java.util.*;

public class Solution완주하지못한선수 {

    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for(String temp : map.keySet()){
            if(map.get(temp) > 0) {
                answer = temp;
                break;
            }
        }
        return answer;
    }
}
