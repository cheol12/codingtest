package programmers;

import java.util.*;
import java.io.*;

//class Solution_호텔방배정 {
//    static boolean[] visited;
//    static long[] answer;
//
//    public long[] solution(long k, long[] room_number) {
//        int customCount = room_number.length;
//
//        visited = new boolean[(int)k+1];
//        answer = new long[customCount];
//
//        for(int i=0; i<customCount; i++){
//            DFS(i, (int)room_number[i], k);
//        }
//        return answer;
//    }
//
//    static void DFS(int person, int roomWant, long k){
//        if(!visited[roomWant]){
//            visited[roomWant] = true;
//            answer[person] = roomWant;
//            return;
//        }
//
//        if( roomWant + 1 <= k) DFS(person,  roomWant + 1, k);
//        else return;
//    }
//}

import java.util.*;

class Solution_호텔방배정 {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }

        return answer;
    }

    private static long findEmptyRoom(long room) {
        if (!map.containsKey(room)) {
            // room이라는 키값이 없다면(=방이 비어있다면)
            // 키값:room, 밸류값:room+1을 맵에 추가
            // 다음 번부터 room 번방을 원하는 사람에겐 room+1번방을 준다는 것을 표시
            map.put(room, room + 1);
            // 지금 사람에겐 room 번방을 준다
            return room;
        }

        //키 값이 있으므로(=원하는 방이 찼으므로)
        //value를 받아온다(=다음 방을 고른다)
        long nextRoom = map.get(room);
        // 다음 방은 비어있는지 확인
        long emptyRoom = findEmptyRoom(nextRoom);
        //
        map.put(room, emptyRoom);
        return emptyRoom;
    }
}
//비유 -
//빈 room을 들어가게 되면 이제 자리 있으니 옆 room으로 가라는 안내문(HashMap)을 문 앞에 붙인다.
//https://bcp0109.tistory.com/188
//전혀 생각치 못한 풀이방식..