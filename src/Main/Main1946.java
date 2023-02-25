package Main;

import java.io.*;
import java.util.*;

public class Main1946 {
    // 그리디 알고리즘
    // 정렬
    public static void main(String args[]) throws IOException{

        // 입력 : 첫째 줄에는 테스트 케이스의 개수 T가 주어진다.
        // 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N이 주어진다.
        // 둘째 줄부터 N개 줄에는 각각의 지원자의 서류, 면접의 순위가 공백을 사이에 두고 한 줄에 주어진다.
        // 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다.

        // 출력 : 각 테스트 케이스에 대해 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        for(int i=0; i<T; i++){

            int N = Integer.parseInt(br.readLine());    // 지원자 수
            int a[][] = new int[N][2];      // 서류, 면접 성적 저장할 객체
            for(int j=0; j<N; j++){
                token = new StringTokenizer(br.readLine());
                a[j][0] = Integer.parseInt(token.nextToken());  // 지원자 서류 성적
                a[j][1] = Integer.parseInt(token.nextToken());  // 지원자 면접 성적
            }

            // 힌트 : 오름차순 정렬부터.
            Arrays.sort(a,(o1,o2) ->
                o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]
            );
            // 0열 기준으로 오름차순 정렬함.
            // 다음 배열의 1열은 작아야함.
            //
            int count1 = 1; // 출력할 합격자 수, 첫 행은 무조건 합격 취급.
            int start = a[0][1];  // 정렬된 객체에서 1열의 초기값. 진행하면서 다음 행으로 업데이트.

            for(int j=1; j<N; j++){
                if(start > a[j][1]) {   // (이전행,1열)이 (현재행,1열)보다 더 크면
                    count1++;           // 현재행=현재 지원자는 합격
                    start = a[j][1];    // (현재행,1열)을 (다음행,1열)과 비교하기 위해 갱신.
                }
            }
            bw.write(String.valueOf(count1 + "\n"));
            // 둘 다 낮거나 둘 다 높으면 안된다.
            // 하나는 낮으면 하나 높고, 하나 높으면 하나 낮아야 함.
            // [1][0] < [2][0] 이면 [1][1] > [2][1] 이어야 함.
            // 같은건 애초에 입력하지 않는다.
            // 따로 리턴값을 준다?
        }
        bw.close();
    }

}

