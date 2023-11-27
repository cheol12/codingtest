package programmers;

import java.io.*;
import java.util.*;

public class Solution폰켓몬 {

    public static void main(String[] args){

        int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));
    }

    // set 이용하는 풀이
    static int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);

        answer = set.size() > nums.length/2 ? nums.length/2 : set.size();

        return answer;
    }

    // map만 이용하는 풀이
    static int solution1(int[] nums){
        int answer = 0;

        Map<Integer,Integer> hashMap = new HashMap<>();

        for(int type : nums){
            // hashmap객체에 넣는다.(type키에 넣는다, (type이 존재하면 키의 value를 반환 아니면 0 반환) + 1
            hashMap.put(type,hashMap.getOrDefault(type,0) + 1);
            // 변수 2개 : size, ?
            // 존재하면 1개
        }

        int typeNum = hashMap.size();
        int pickNum = nums.length / 2;
        if(typeNum < pickNum) answer = typeNum;
        else answer = pickNum;

        return answer;
    }
}
