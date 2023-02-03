package Main;

import java.io.*;
import java.util.StringTokenizer;

public class Main2864 {
    // 문제 제목 : 5와 6의 차이
    // 알고리즘 분류 : *그리디 알고리즘, 수학, 문자열, 사칙연산
    public static void main(String[] args) throws IOException {

        BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
        String str = bfreader.readLine();
        StringTokenizer strtoken = new StringTokenizer(str);

        String A = strtoken.nextToken();
        String B = strtoken.nextToken();

        A = A.replaceAll("5","6");
        B = B.replaceAll("5","6");

        int C = Integer.parseInt(A);
        int D = Integer.parseInt(B);

        int max = C + D;

        A = A.replaceAll("6","5");
        B = B.replaceAll("6","5");

        C = Integer.parseInt(A);
        D = Integer.parseInt(B);

        int min = C + D;

        BufferedWriter bfwriter = new BufferedWriter(new OutputStreamWriter(System.out));

        bfwriter.write(min + " " + max);

        bfwriter.close();
    }
}