package programmers;

import java.util.*;

public class Solution다리를지나는트럭 {

    public static void main(String[] args) {
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};

        int bridge_length = 3;
        int weight = 10;
        int[] truck_weights = {7, 4, 1, 5, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 문제 부연 설명이 아쉽다..
        // bridge_length == 직역 그대로 다리 길이로 받아들이자
        // weight = 다리 위 무게 합의 최댓값

        // 혼자 생각해본 예제 입력
        // {7, 4, 1, 5, 5, 6}
        // - - -  0초 시작
        // 7 - - +1초 (7올라탐)
        // 4 - - +3초 (4올라탐, 7건넘)
        // 1 4 - +1초 (1올라탐)
        // 5 1 4 +1초 (5올라탐)
        // - 5 1 +1초 (4건넘)
        // 5 - 5 +1초 (5올라탐, 1건넘)
        // - 5 - +1초 (5건넘)
        // - - 5 +1초
        // 6 - - +1초 (6올라탐, 5건넘)
        // - 6 - +1초
        // - - 6 +1초
        // - - - +1초 (6건넘)
        // => 올바른 return 값은 14

        Queue<Integer> bridgeTruckQue = new ArrayDeque<>();
        int currTime = 0;   // 현재 시간
        int currWeight = 0; // 현재 다리 위 트럭 무게

        for(int truck : truck_weights){
            while(true){
                // 다리 위 트럭이 없다면
                if(bridgeTruckQue.isEmpty()){
                    bridgeTruckQue.offer(truck); // 트럭 올리고
                    currTime++;                  // 1초 증가
                    currWeight += truck;         // 다리 위 무게 합
                    break;
                }
                // 트럭이 다리 길이만큼 있으면 / 이 조건으로 '큐 사이즈 == 다리 길이' 로 고정시키는 꼴
                else if(bridgeTruckQue.size() >= bridge_length) {
                    currWeight -= bridgeTruckQue.poll();
                }
                // 다리 위 트럭이 올라갈 공간이 있고
                else{
                    // 무게 문제 없이 올라갈 수도 있을 때
                    if(truck + currWeight <= weight){
                        bridgeTruckQue.offer(truck);
                        currTime++;
                        currWeight += truck;
                        break;
                    }
                    // 무게 문제로 올라갈 수 없을 때
                    else{
                        bridgeTruckQue.offer(0);
                        currTime++;
                    }
                }
            }
        }
        answer = currTime + bridge_length;
        return answer;
    }
}
