package Main;

import java.io.*;
import java.util.*;

public class Main2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        // 목표하는 블루레이 개수
        int M = Integer.parseInt(token.nextToken());

        int[] lecture = new int[N];
        // 모든 강의 시간 합을 max로 두고
        int max = 0;
        // 강의 중 가장 긴 강의 시간을 min으로 두고 비교한다
        int min = 0;

        // 블루레이 크기를 설정할 때, 가장 큰 하나의 강의가 무조건 블루레이 안에 들어가야하기 때문에
        // 블루레이 크기의 최솟값이라는 의미로 가장 큰 강의 시간을 min 으로 설정

        token = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            // 강의 입력
            lecture[i] = Integer.parseInt(token.nextToken());
            // 가장 긴 강의 시간
            if(lecture[i] > min) min = lecture[i];
            // 강의 합
            max += lecture[i];
        }

        int mid = 0;

        // max = 45
        // min = 9
        while(min <= max){
            // mid = 27
            mid = (min + max) / 2;

            // 하나의 블루레이에 들어갈 강의 시간의 합
            int sum = 0;
            // 블루레이의 개수
            int count = 0;

            for(int i=0; i<N; i++){
                // 1 + 2 + 3 + 4 + 5 + 6 + 7에서
                // 7 을 더할 때 if문 조건 성립
                if(sum + lecture[i] > mid){
                    // 21
                    // 여태 합한 21이 초기화되면서
                    sum = 0;
                    // 하나의 블루레이를 카운트
                    count++;
                }
                // 7에 해당하는 강의는 다음 블루레이에 삽입
                sum += lecture[i];
            }

            // 남아있는 강의가 있으면 블루레이 하나 더 추가
            if(sum != 0) count++;

            // 목표하는 블루레이 최소 개수보다 크면 다시 진행
            if(count > M) min = mid + 1;
            else max = mid - 1;
        }
        bw.write(min + "");
        bw.close();
    }
}
//https://velog.io/@chosj1526/%EB%B0%B1%EC%A4%80-2343-%EA%B8%B0%ED%83%80-%EB%A0%88%EC%8A%A8-JAVA
//이분 탐색(Binary Search)는 오름차순 혹은 내림차순으로 정렬된 수열에서 검색하는 알고리즘이다.
// 반 토막씩 쪼개가며 탐색 범위를 좁혀나간다.
// 알고리즘적으로는 min, mid, max (혹은 left, key, right) 설정하고 계속 갱신해나가는 것이 포인트
