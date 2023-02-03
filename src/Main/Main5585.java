package Main;

import java.io.IOException;
import java.util.Scanner;

public class Main5585 {
    // 문제 제목 : 거스름돈
    // 알고리즘 분류 : *그리디 알고리즘
    public static void main(String[] args) throws IOException {

        // 1000원에서 돈을 지불할 가격을 입력, 잔돈으로 받을 동전의 개수, 동전:500,100,50,10,5,1
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();   // 지불할 돈

        int b1 = (1000 - A)/500;
        int b2 = (1000 - A)%500;
        int c1 = b2/100;
        int c2 = b2%100;
        int d1 = c2/50;
        int d2 = c2%50;
        int e1 = d2/10;
        int e2 = d2%10;
        int f1 = e2/5;
        int f2 = e2%5;
        int g1 = f2/1;
        int g2 = f2%1;

        System.out.println(b1 + ", " + c1 + ", " + d1 + ", " + e1 + ", " + f1 + ", " + g1);
        System.out.println(b1 + c1 + d1 + e1 + f1 + g1);

    }
}
