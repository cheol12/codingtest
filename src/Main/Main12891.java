package Main;

import java.io.*;
import java.util.*;

public class Main12891 {
    static int S,P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        S = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        char[] dna = br.readLine().toCharArray();

        int[] dnaRule = new int[4];
        token = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            dnaRule[i] = Integer.parseInt(token.nextToken());
        }

        int[] nowDNA = new int[4];

        for(int i=0; i<P; i++){
            char v = dna[i];
            if(v == 'A') nowDNA[0]++;
            else if(v == 'C') nowDNA[1]++;
            else if(v == 'G') nowDNA[2]++;
            else if(v == 'T') nowDNA[3]++;
        }

        int result = 0; //

        if(check(dnaRule, nowDNA)) result++;

        for(int i=1; i<=S-P; i++){
            char removeChar = dna[i-1];
            char addChar = dna[i + P - 1];

            if(removeChar == 'A') nowDNA[0]--;
            else if(removeChar == 'C') nowDNA[1]--;
            else if(removeChar == 'G') nowDNA[2]--;
            else if(removeChar == 'T') nowDNA[3]--;

            if(addChar == 'A') nowDNA[0]++;
            else if(addChar == 'C') nowDNA[1]++;
            else if(addChar == 'G') nowDNA[2]++;
            else if(addChar == 'T') nowDNA[3]++;

            if(check(dnaRule, nowDNA)) result++;
        }


        bw.write(result + "");
        bw.close();
    }

    static boolean check(int[] dnaRule, int[] nowDNA){

        for(int i=0; i<4; i++){
            if(dnaRule[i] > nowDNA[i]) return false;
        }
        return true;
    }
}

// 슬라이딩 윈도우가 아닌 단순 for문
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer token;
//
//        token = new StringTokenizer(br.readLine());
//        S = Integer.parseInt(token.nextToken());
//        P = Integer.parseInt(token.nextToken());
//
//        String temp = br.readLine();
//
//        token = new StringTokenizer(br.readLine());
//        int countA = Integer.parseInt(token.nextToken());
//        int countC = Integer.parseInt(token.nextToken());
//        int countG = Integer.parseInt(token.nextToken());
//        int countT = Integer.parseInt(token.nextToken());
//        int result = 0;
//
//        int[] countArr = new int[4];
//
//        for(int i=0; i<=S-P; i++){
//            String temp2 = temp.substring(i, i+P);
//            countArr[0] = countA;
//            countArr[1] = countC;
//            countArr[2] = countG;
//            countArr[3] = countT;
//
//            for(int j=0; j<P; j++){
//                String comparison = temp2.substring(j, j+1);
//                if(comparison.equals("A") && countArr[0] != 0){
//                    countArr[0] -= 1;
//                }else if(comparison.equals("C") && countArr[1] != 0){
//                    countArr[1] -= 1;
//                }else if(comparison.equals("G") && countArr[2] != 0){
//                    countArr[2] -= 1;
//                }else if(comparison.equals("T") && countArr[3] != 0){
//                    countArr[3] -= 1;
//                }
//            }
//
//            if(checked(countArr)) result++;
//        }
//
//
//        bw.write(result+"");
//        bw.close();
//    }
//
//    static boolean checked(int[] countArr){
//        for(int i=0; i<4; i++){
//            if(countArr[i] > 0) {
//                return false;
//            }
//        }
//        return true;
//    }