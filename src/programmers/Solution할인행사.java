package programmers;

import java.util.*;

public class Solution할인행사 {
    public static void main(String[] args){
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

//        String[] want = {"apple"};
//        int[] number = {10};
//        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution(want, number, discount));
    }


    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }

        int totalCount = 0;
        for(int i=0; i<number.length; i++){
            totalCount += number[i];
        }

        return calculate(map, totalCount, discount);
    }

    static int calculate(Map<String, Integer> map, int totalCount, String[] discount){
        Map<String, Integer> tempMap;
        int result = 0;

        for(int i=0; i <= discount.length-totalCount; i++){
            tempMap = new HashMap<>(map);
            result++;
            for(int j=i; j<i+totalCount; j++){
                if(!tempMap.containsKey(discount[j])){
                    result--;
                    break;
                }
                else{
                    tempMap.put(discount[j], tempMap.get(discount[j]) - 1);
                    if(tempMap.get(discount[j]) == 0) tempMap.remove(discount[j]);
                }
            }
        }
        return result;
    }
}
