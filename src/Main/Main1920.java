package Main;

import java.io.*;
import java.util.*;

public class Main1920 {
    // 문제 제목 : 수 찾기
    // 알고리즘 분류 : 자료 구조, 정렬, 이분 탐색
    public static void main(String[] args) throws IOException {

        // N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
        // 첫째 줄 : N개
        // 둘째 줄 : N개 정수들 각각의 값
        // 셋째 줄 : M개
        // 넷째 줄 : M개 정수들 각각의 값
        // 출력 : 각각의 M 값들이 N에 있으면 1 없으면 0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer strtoken;

        int N = Integer.parseInt(br.readLine());   // 숫자 개수
        int[] A = new int[N];     // int 배열 객체 생성

        strtoken = new StringTokenizer(br.readLine());     // 다음 줄의 입력은 토큰화해서 띄어쓰기로 구분
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strtoken.nextToken());    // 앞서 설정한 N개의 배열에 값 채워넣기.
        }

        Arrays.sort(A);   // 이분 탐색을 위해 오름차순 정렬

        // 내 풀이 시작
        int M = Integer.parseInt(br.readLine());       // 질문할 숫자 개수

        strtoken = new StringTokenizer(br.readLine());

        System.out.println("\n(오름차순) A[크기:" + N + "]배열 : " + Arrays.toString(A));


        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(strtoken.nextToken());  // 질문할 숫자들 입력

            // Arrays.binarySearch( , ) => 이분 탐색 알고리즘 방식을 이용해서 => 배열A 에서 x 값이 어디있는지 배열 위치를 리턴하는 함수
            int y = Arrays.binarySearch(A, x);    // 인덱스값을 리턴

            if (0 <= y && y < N) {
                System.out.println("A[" + y + "] 에 있음");
                bw.write("1\n");
            } else {
                // 찾으려는 값이 없을 때는,
                // 찾으려는 값을 배열 바깥에 저장 = 영향 없는 가상의 저장소에 저장.
                // ( ex) N=4일 때, A[4]에서 찾으려는 값이 없다면 A[5]에 저장),
                // 배열 바깥을 나타내는 리턴값은 상관없는 5에 -1을 곱하고 1을 빼게 된다.
                System.out.println(y + "없음");
                bw.write("0\n");
            }

        }

        bw.close();
    }

    static int binaryS(int[] arr, int key){


        return key;
    }
}
       // 내 풀이 끝

       // 하루코딩 풀이
//       int N = Integer.parseInt(br.readLine());   // 숫자 개수
//       int[] A = new int[N];     // int 배열 객체 생성
//
//       strtoken = new StringTokenizer(br.readLine());     // 다음 줄의 입력은 토큰화해서 띄어쓰기로 구분
//       for(int i=0; i<N; i++){
//           A[i] = Integer.parseInt(strtoken.nextToken());    // 앞서 설정한 N개의 배열에 값 채워넣기.
//       }
//
//       Arrays.sort(A);   // 이분 탐색을 위해 오름차순 정렬
//
//       int M = Integer.parseInt(br.readLine());       // 질문할 숫자 개수
//       strtoken = new StringTokenizer(br.readLine());
//       for(int i=0; i<M; i++){
//           boolean find = false;
//           int target = Integer.parseInt(strtoken.nextToken()); // 찾을 수
//           int start = 0;   // 시작 인덱스 설정
//           int end = A.length - 1;   // 종료 인덱스 설정
//           while(start <= end){
//               int mid_index = (start+end)/2;   // 중간 인덱스 설정
//               int mid_value = A[mid_index];
//               if(mid_value>target){
//                   end = mid_index - 1;
//               }else if(mid_value<target){
//                   start = mid_index + 1;
//               }else{
//                   find = true;
//                   break;
//               }
//           }
//           if(find) bw.write("1\n");
//           else bw.write("0\n");
//       }
//       bw.close();
       // 하루코딩 풀이
//
//   }
//
//}
