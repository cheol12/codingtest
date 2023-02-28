package programmers;

import java.io.*;
import java.util.*;
// https://school.programmers.co.kr/learn/courses/30/lessons/150368

public class Solution150368 {
    static int[][] users;
    static int[] emoticons;
    static int[] discount;

    public static void main(String args[]) throws IOException{
        // 2차원 배열에 고객의 구매 기준 : 기준 비율, 기준 가격 입력
        // 1차원 배열에 각 이모티콘의 가격 입력.
        // 기준 비율과 기준 가격에 부합해서 플러스에 가입한 인원 수와 이모티콘 매출액 출력.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int n = Integer.parseInt(br.readLine());    // 사람 수
        int m = Integer.parseInt(br.readLine());    // 이모티콘 개수

        users = new int[n][2];  // 해당 고객의 비율, 가격 저장
        emoticons = new int[m]; // 각 이모티콘의 가격 저장

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            users[i][0] = Integer.parseInt(token.nextToken());  // 비율
            users[i][1] = Integer.parseInt(token.nextToken());  // 가격 넘어가면 서비스 가입
        }
        for(int i=0; i<m; i++){
            emoticons[i] = Integer.parseInt(br.readLine()); // 이모티콘 가격
        }

        int signup_count = 0;

        discount = new int[]{10, 20, 30, 40};   // 10%,20%,30%,40% 할인율이 담긴 배열
        // 각 이모티콘의 할인율은 10,20,30,40% 중에서 선택가능.
        // i번 이모티콘이 10,20,30,40% 일 때 + i+1번 이모티콘이 10,20,30,40일 때...

        // 임의의 한 사람이 이모티콘을 구매할 때,
        // 할인의 모든 경우를 반복.
        // 각 할인율에 따른 이모티콘의 판매액 표시. 하기 위해 이모티콘 개수만큼 반복.
        // 40 40 40 40, 40 40 40 30, 40 40 40 20, 40 40 40 10, 40 40 30 40, ...
        ArrayList<Integer> sell = new ArrayList<>(); // 이모티콘 판매액의 모든 경우의 수를 담을 리스트


        // m행 4열 배열을 만들어서 m개 이모티콘의 할인 적용한 4가지 가격 모두 저장
        int[][] discount_sell = new int[m][4];  // 할인율을 적용한 실제 판매가격
        for(int i=0; i<m; i++){
            for(int j=0; j<discount.length; j++){
                discount_sell[i][j] = (int)(emoticons[i] * ((float)(100 - discount[j]) / 100));
            }
        }

        // 이모티콘 모두 하나씩 구매하는 경우 = 4의(m제곱) 경우의 수
        //7000원 - 10%, 9000원 - 10%,
        //7000원 - 10%, 9000원 - 20%,
        //...
        //7000원 - 40%, 9000원 - 40%
        // 7000원의 할인율이 기준인 30%을 넘는다면 실행.= m번째 이모티콘의 할인율이 n번째 사람의 기준인 a[n][0]을 넘는다면 실행.
        // 7000원의 할인율 30%로 결정 = m번째 이모티콘의 할인율 고정시키고. 다음 이모티콘의 할인율 결정하기.
        // 다음 9000원의 할인율이 기준인 30%을 넘는다면 실행 = m+1번째 이모티콘의 할인율이 n번째 사람의 기준인 a[n][0]을 넘는다면 실행.
        // int[][] users, int[] emoticons
        //


        for(int a=0; a<n; a++) {    // 해당하는 고객이 살 수 있는 경우.
            for (int i = 0; i < m; i++) {
                // 이모티콘 1번이 10%할인일 때 = ... = 0행 0열,
                // 이모티콘 m번이 40%할인일 때 = ... = m행 3열.
                for (int j = 0; j < discount.length; j++) { // m번째 이모티콘이 10%일 때
                    if (discount[j] < users[a][0]) continue;    // 해당 이모티콘의 할인율이 고객기준보다 낮으면 패스.

                    for (int k = 0; k < discount.length; k++) { // 20%일 때
                        if (discount[k] < users[a][1]) continue;    // 해당 이모티콘의 할인율이 고객기준보다 낮으면 패스.

                        for (int l = 0; l < discount.length; l++) {
                            if (discount[l] < users[a][2]) continue;    // 해당 이모티콘의 할인율이 고객기준보다 낮으면 패스.

                            for (int o = 0; o < discount.length; o++) {
                                if (discount[o] < users[a][3]) continue;    // 해당 이모티콘의 할인율이 고객기준보다 낮으면 패스.

                                for(int c=0; c<n; c++){
                                    // 해당하는 고객이 살 수 있는 경우만 취급.

                                }
                                    int b = discount_sell[i][j] +
                                            discount_sell[i][k] +
                                            discount_sell[i][l] +
                                            discount_sell[i][o];    // 이모티콘마다 할인율이 상이한 가격
                                    sell.add(b);
                                }
                            }
                        }
                }
            }
        }



        bw.write(Arrays.deepToString(users)+ "\n");
        bw.write(Arrays.toString(emoticons)+ "\n");
        bw.write(Arrays.deepToString(discount_sell)+ "\n");

        bw.close();

    }
    // n번째 사람이 m개의 이모티콘을 모두 구매할 때(각 할인율에 따라) 총합 리턴하기, 가입여부
    static int cal(int[][] discount_sell, int[][] users, int n, int m){
        // 매개변수는 : 1번째부터 m번째 이모티콘의 10~40%할인액이 담겨있는 배열, 이 사람의 할인율 기준, 사람 수, 이모티콘 수

        int sell_sum;

        discount_sell = new int[m][4];  // 할인율을 적용한 실제 판매가격
        for(int i=0; i<m; i++){
            for(int j=0; j<discount.length; j++){
                discount_sell[i][j] = (int)(emoticons[i] * ((float)(100 - discount[j]) / 100));
            }
        }
        int[][] num_sum = new int[n][4];
        int result = 0;



        return result;     // 총합 리턴
    }
}
