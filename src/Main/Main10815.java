package Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10815 {
    // 문제 제목 : 숫자 카드
    // 알고리즘 분류 : 자료 구조, 정렬, 이분 탐색
   public static void main(String[] args) throws IOException {

       // 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
       // 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
       // 첫째 줄 : N = 상근이 가지고 있는 숫자 카드 개수
       // 둘째 줄 : 상근이가 갖고 있는 각 숫자 카드 값 설정
       // 셋째 줄 : M = 상근이에게 질문할 숫자 카드 개수
       // 넷째 줄 : 질문할 각 숫자 카드 값 설정
       // 출력 : 상근이가 해당 숫자 카드를 가지고 있다면 카드마다 1 출력, 없다면 0 출력

       BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bfwriter = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer strtoken;

       int N = Integer.parseInt(bfreader.readLine());   // 카드의 개수
       int[] s_g_card = new int[N];     // 카드 담을 int 배열 객체 생성

       strtoken = new StringTokenizer(bfreader.readLine());     // 다음 줄의 입력은 토큰화해서 띄어쓰기로 구분
       for(int i=0; i<N; i++){
           s_g_card[i] = Integer.parseInt(strtoken.nextToken());    // 앞서 설정한 N개의 카드 배열에 값 채워넣기.
       }

       Arrays.sort(s_g_card);   // 이분 탐색을 위해 오름차순 정렬

       int M = Integer.parseInt(bfreader.readLine());       // 질문할 숫자 카드 개수

       strtoken = new StringTokenizer(bfreader.readLine());

       System.out.println("\n상근이의 카드(오름차순) : " + Arrays.toString(s_g_card));

       for(int i=0; i<M; i++){
           int a = Integer.parseInt(strtoken.nextToken());

           if(BinarySearch2(s_g_card,a) == 1) {
               bfwriter.write("1 ");
           }
           else if(BinarySearch2(s_g_card,a) == 0) {
               bfwriter.write("0 ");
           }
       }

       bfwriter.close();


//       if(c != 0){
//           bfwriter.write("Yes");
//
//       }else{
//           bfwriter.write("No");
//       }
//       bfwriter.close();
   }
    private static int BinarySearch2(int[] s_g_card, int a){
        int left = 0;
        int right = s_g_card.length - 1;
        int mid;

        while (left <= right){
            mid = (left + right) / 2;   // 범위 재설정마다 기준이 될 mid값 갱신
            System.out.println("left:" + left + ", right:" + right + " ==> mid값:" + mid);

            if(s_g_card[mid] == a){
                return 1;
            }else if(s_g_card[mid] < a){
                left = mid + 1;     // 기준으로 잡은 배열의 중간값이 찾으려는 값보다 작으면 범위 재설정 -> 범위의 최솟값을 중간값보다 높인다.
            }else{
                right = mid - 1;
            }
        }

        return 0;
    }
}
