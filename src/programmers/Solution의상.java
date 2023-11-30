package programmers;

import java.util.*;

public class Solution의상 {

    public static void main(String[] args){
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }

    static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hm = new HashMap<>();

        for(String[] temp : clothes){
            hm.put(temp[1], hm.getOrDefault(temp[1], 0) + 1);
        }

        for(String temp : hm.keySet()){
            answer *= hm.get(temp) + 1;
        }
        answer -= 1;
        return answer;
    }
}
