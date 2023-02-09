package Main;

import java.io.*;
import java.util.*;

class Main1546 {
    // 문제 제목 : 평균
    // 알고리즘 분류 : 수학, 사칙연산
    public static void main(String args[]) throws IOException{
        // 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다.
        // 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
        // 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
        // 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>(); // 나누기 연산때문에 실수 데이터로 저장(실수 데이터 : double, float / 기본 형식은 double)

        token = new StringTokenizer(br.readLine());
        Integer b = 0;    // 연산 후 성적들의 합

        for(int i=0; i<N; i++){
            a.add(Integer.parseInt(token.nextToken()));
            b += a.get(i);
        }

        Integer M = Collections.max(a); // 세준이 성적 중 최대값

        bw.write(String.valueOf(b*100.0/N/M));      // int는 소수점이 나오면 0으로 취급 -> 연산에 .0을 붙여서 소수점 결과도 나오게 설정.
        bw.close();
    }
}
