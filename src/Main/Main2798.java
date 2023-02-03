package Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2798 {
    // 문제 제목 : 블랙잭
    // 알고리즘 분류 : 브루트포스 알고리즘
    public static void main(String[] args) throws IOException {

        // 입력한 N개의 숫자들 중 3개를 골라서 M에 가깝게 더한다
        // N개의 숫자들을 리스트에 담는다. 리스트에 담긴 N개의 원소들 중 3개를 골라 일일이 더해보고 더 한 값들 또한 새로운 리스트에 담는다.
        // 더 한 값들의 리스트에 있는 원소들 중 (제일 큰 값)&&(M보다 작은 값) = 정답
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> cardlist = new ArrayList<Integer>();     // N개의 카드 목록

        ArrayList<Integer> cardsumlist = new ArrayList<Integer>();  // N개 중 3개를 더해서 나올 수 있는 합들의 모든 경우의 수

        int sumMax;     // cardsumlist 중 최대값

        for(int i=0; i<N; i++){
            cardlist.add(sc.nextInt());
        }

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    // 합이 될 수 있는 모든 경우의 수 도출
                    int sum = cardlist.get(i) + cardlist.get(j) + cardlist.get(k);

                    // 크기가 M이하인 sum만 cardsumlist에 담는다.
                    if(sum<=M){
                        cardsumlist.add(sum);
                    }
                }
            }
        }

        // cardsumlist 원소 중 최대값 도출
        sumMax = Collections.max(cardsumlist);

        System.out.println("N="+cardlist.size());
        System.out.println(cardlist.toString());
        System.out.println(cardsumlist.toString());
        System.out.println(sumMax);

    }
}
