package programmers;

import java.io.*;
import java.util.*;

public class Solution_광물캐기 {
    public static void main(String[] args) throws IOException {
        int[] picks = {1,3,2};
        String[] minerals = {"diamond","diamond","diamond","iron","iron",
                "diamond","iron", "stone"};

        int[] picks1 = {0, 1, 1};
        String[] minerals1 = {"diamond", "diamond", "diamond", "diamond",
                "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks, minerals));

    }
    static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        // 다이아 곡괭이 1, 철 곡괭이 3, 돌 곡괭이 2
        int[] tempPick = picks;
        // 곡괭이 번호, 남은 곡괭이 개수
        Map<Integer, Integer>  map = new HashMap<>();
        for(int i=0; i<3; i++){
            map.put(i, tempPick[i]);
        }

        Queue<String> q = new LinkedList<>(Arrays.asList(minerals));

        while(!q.isEmpty()){

            if(map.get(0) + map.get(1) + map.get(2) <= 0) {
                return answer;
            }

            Queue<String> qtemp = new LinkedList<>();
            for(int i=0; i<5; i++){
                qtemp.offer(q.poll());
            }
            String temp = qtemp.poll();
            if(temp.equals("diamond")){
                if(map.get(0) > 0){
                    answer += 1;
                    map.put(0, map.get(0)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
                else if(map.get(1) > 0){
                    answer += 5;
                    map.put(1, map.get(1)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 5;
                    }
                }
                else if(map.get(2) > 0){
                    answer += 25;
                    map.put(2, map.get(2)-1);
                    while (!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 25;
                    }
                }
            }

            else if(temp.equals("iron")){

                if(map.get(1) > 0){
                    answer += 1;
                    map.put(1, map.get(1)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
                else if(map.get(0) > 0){
                    answer += 1;
                    map.put(0, map.get(0)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
                else if(map.get(2) > 0){
                    answer += 5;
                    map.put(2, map.get(2)-1);
                    while (!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 5;
                    }
                }
            }

            else if(temp.equals("stone")){

                if(map.get(2) > 0){
                    answer += 1;
                    map.put(2, map.get(2)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
                else if(map.get(1) > 0){
                    answer += 1;
                    map.put(1, map.get(1)-1);
                    while(!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
                else if(map.get(0) > 0){
                    answer += 1;
                    map.put(0, map.get(0)-1);
                    while (!qtemp.isEmpty()){
                        qtemp.poll();
                        answer += 1;
                    }
                }
            }
        }


        return answer;
    }
}
