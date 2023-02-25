package Main;

import java.io.*;
import java.util.*;

public class Main1931 {
    // 그리디 알고리즘
    // 정렬
    public static void main(String args[]) throws IOException{
        // 한 개의 회의실 안에 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
        // 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을
        // 사용할 수 있는 회의의 최대 개수를 찾아보자. 회의의 시작시간과 끝나는 시간이 같을
        // 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

        // 입력 : 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가
        // 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는
        // 시간은 2의31승-1보다 작거나 같은 자연수 또는 0이다.

        // 출력 : 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

        // 시작과 끝을 나타낼 때 = ( a , b ) 좌표로 나타낼 수 있을 때는
        // int[][] a; 처럼 2차원 배열로 나타내기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());

        // 최초 회의 시작이 0일 때, 0~6,6~10,12~14 => 회의는 3개 확인.
        // 시작이 1일 때, 1~4,5~7,8~11,12~14 => 4개 확인
        // 그 다음 수 2일 때, 2~13 => 1개
        // 그 다음 수 3, 3~5,5~7,8~11,12~14 => 4개
        // 그 다음 수 5, 5~7,8~11,12~14 => 3개
        // 그 다음 수 ...

        int [][] a = new int[N][2];
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(token.nextToken());  // 시작시각
            a[i][1] = Integer.parseInt(token.nextToken());  // 끝시각
        }

        Arrays.sort(a, (o1,o2) ->
            o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]
        );
        // o1와 o2가 같지 않다면
        // -> 종료시각 오름차순으로 ( = 빠른 순 ).
        // o1와 o2가 같다면
        // -> 시작시간 오름차순으로 ( = 빠른 순 ).
        // 으로 정렬

        // 앞서 정의한 2차원 배열 a에서 각 종료 시각을 시작으로 했을 때, 몇 개의 회의를 할 수 있는지 저장.
        ArrayList<Integer> count2 = new ArrayList<Integer>();

        for(int i=0; i<N; i++){

            int end = a[i][1];      // 종료시각 순서대로 2차원 배열 원소 선택. = 첫 회의로 선택할 객체.
            int count1 = 1;         // 회의 개수 = 1개 회의 한 것으로 확인.

            for(int j=i+1; j<N; j++){

                if(end <= a[j][0]){ // 해당 종료시각 <= 시작시각 인 2차원 배열 원소 확인.
                    end = a[j][1];  // 확인한 것의 종료시각을 다시 end로 업데이트.
                    count1++;       // 회의 개수++;
                }
            }
            count2.add(count1);
        }

        bw.write("\n 정렬한 2차원 배열a = " + Arrays.deepToString(a) +
                "\n 각 종료 시각기준 회의 개수 count2 : " + count2 +
                "\n" + String.valueOf(Collections.max(count2)));
        bw.close();
    }

}

