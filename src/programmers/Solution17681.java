package programmers;

import java.util.*;
import java.io.*;

//2018 KAKAO BLIND RECRUITMENT
//[1차] 비밀지도
class Solution17681 {
    static int[] answer;
    static HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        bw.write(Arrays.toString(solution(n, arr1, arr2)));

        bw.close();
    }
    static String[] solution(int n, int[] arr1, int[] arr2) {
        // # = 벽
        String[] answer = new String[n];

        // 입력받음 arr1 = {9, 20, 28, 18, 11};
        // 입력받음 arr2 = {30, 1, 21, 17, 28};

        for(int i=0; i<n; i++){
            String tempstring = "";
//            String[] a1 = Integer.toString(arr1[i],2).split("");
//            String[] a2 = Integer.toString(arr2[i],2).split("");

            String[] a1 = Integer.toBinaryString(arr1[i]).split("");
            String[] a2 = Integer.toBinaryString(arr2[i]).split("");



            for(int j=0; j<n; j++){
                if(a1[j].equals("1") || a2[j].equals("1"))
                    tempstring += "#";
                else
                    tempstring += " ";
            }
            answer[i] = tempstring;
        }
        return answer;
    }
}
//https://velog.io/@hi_potato/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-1%EC%B0%A8-%EB%B9%84%EB%B0%80%EC%A7%80%EB%8F%84-JAVA