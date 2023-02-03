package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        // id_list = 이용자 id 배열
        // report = 이용자가 신고한 id 배열
        // k = 정지 당하는 신고 횟수 기준
//      https://rovictory.tistory.com/59
        int[] answer = new int[id_list.length]; // 메일 받은 횟수

        // HashSet 성질로 '신고 당한 사람의 배열 객체인 report' 안에 중복 제거
        HashSet<String> reportSet = new HashSet<>();
        for(String s : report){
            reportSet.add(s);
        }

        // K : V = 신고당한사람 : 신고자 형식으로 만들 의도로 HashMap 선언
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        for(String s : reportSet){
            // split으로 문자열 나누기
            // ["muzi frodo"]와 같은 형식으로 입력되는 report 객체에서 신고자, 신고 당한자로 나누기 위함
            String[] temp = s.split(" ");
            String reporter = temp[0];  // 신고자
            String reportee = temp[1];  // 신고당한자

            ArrayList<String> list = reportMap.get(reportee);

            // value가 비어있다면
            if(reportMap.get(reportee)==null){
                // 리스트 초기화
                list = new ArrayList<>();
            }
            list.add(reporter);
            reportMap.put(reportee, list);

        }

        // 신고자에게 정지 메일 보내기 위해 카운팅하는 HashMap
        HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
        // reportMap에서 value list를 가져오기
        for(ArrayList<String> list : reportMap.values()){
            // list.size() = reportMap의 밸류값에서 list형식으로 저장되어있는 '신고자'들을 보고 신고 횟수를 추출한 것
            // 이 list.size()값이 k보다 크면
            if(list.size() >= k){
                for(String s : list){
                    // cntMap에 신고자를 key로 넣고 value에 메일 발송 카운트
                    // getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
                    cntMap.put(s,cntMap.getOrDefault(s,0) + 1);
                }
            }
        }

        // 카운팅을 기반으로 answer 배열 채우기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = cntMap.getOrDefault(id_list[i], 0);
        }
        return answer;


//        https://hu-coding.tistory.com/107
//        HashMap<String, Integer> idMap = new HashMap<>();// 유저 순서 저장
//        HashMap<String, HashSet<String>> map = new HashMap<>();// 자신을 신고한 유저 set
//
//        for(int i=0; i<id_list.length; i++){
//            idMap.put(id_list[i],i);
//            map.put(id_list[i],new HashSet<>());
//        }

    }
}
