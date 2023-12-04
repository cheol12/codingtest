package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution전화번호목록 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(solution(phone_book));
    }
//
    static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> hm = new HashMap<>();

        for(String temp : phone_book){
            hm.put(temp, 0);
        }

        for(String temp : phone_book){
            for(int i=1; i<temp.length(); i++){
                if(hm.containsKey(temp.substring(0, i)))
                    answer = false;
            }
        }

        return answer;
    }
}
