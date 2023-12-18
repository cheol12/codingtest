package programmers;

import java.util.*;

public class Solution주식가격 {
    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    static int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        for(int i=0; i<prices.length-1; i++){
            int notDown = 0;
            for(int j=i+1; j<prices.length; j++){
                notDown++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = notDown;
        }
        answer[prices.length-1] = 0;
        return answer;
    }
}
