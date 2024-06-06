package programmers;

import java.util.*;

class Solution캐시 {
    public static void main(String[] args) {
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(3, cities));
    }

    // 문제 :
    // 도시 이름을 검색해서 DB 에서 도시의 맛집들을 불러들여야 한다.
    // 그런데 DB 데이터들을 가져오는 데에 실행시간이 오래 걸려 개선하기 위해
    // 실행시간 측정 프로그램을 만드려고 한다.
    // 캐시를 이용하여 DB 작업 중 검색하려는 도시를 더 빠르게 불러들인다.
    //
    // 유의사항 :
    // 캐시 교체 알고리즘은 LRU,
    // 캐시사이즈, 도시 목록은 입력으로 주어진다.
    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Deque<String> cacheQue = new ArrayDeque<>();
        // LRU = 오랫동안 사용 안한 것을 제거한다.
        // q.size() = cacheSize
        // 캐시에 있을 경우 실행시간 = 1
        // 캐시에 없을 경우 실행시간 = 5

        for(int i=0; i<cities.length; i++){
            // 대소문자 구분 안하는 것 주의.
            String currCity = cities[i].toLowerCase();

            // LRU 캐시 교체 알고리즘에 의해
            // 도시가 캐시에 있어도 가장 최근에 사용했단 것을 표현하기 위해
            // 캐시에 있든 없든 도시를 '캐시 큐'에 넣는 것은 공통 작업.

            // 현재 처리할 도시가 캐시에 있으면
            if(cacheQue.contains(currCity)){
                cacheQue.remove(currCity);
                answer += 1;
            }
            // 캐시에 없는데
            else{
                // 캐시 사이즈 여유도 없으면
                if(cacheQue.size() >= cacheSize) cacheQue.poll();
                answer += 5;
            }
            // 캐시에 있든 없든 무조건 큐에 넣기
            cacheQue.offer(currCity);
        }
        // 7번 17번 테스트 반례 처리 -> 캐시 사이즈 = 0일 때
        return cacheSize == 0 ? cities.length * 5 : answer;
    }
}