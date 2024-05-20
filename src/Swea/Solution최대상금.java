package Swea;

import java.io.*;
import java.util.*;

public class Solution최대상금 {

	static int[] number;
	static int N, result;
	
	// DFS + 백트래킹
	// startIdx = 교환 시작할 인덱스, cnt = 현재까지 교환된 횟수 
	static void DFS(int startIdx, int cnt) {
		if(cnt == N) {
			int max = 0;
			for(int i=0; i<number.length; i++) {
				int temp = (int) Math.pow(10, number.length - (i + 1)) * number[i];
				max += temp;
			}
			result = Math.max(max, result);
			return;
		}
		
		for(int i=startIdx; i<number.length; i++) {
			for(int j=i+1; j<number.length; j++) {
				int temp = number[i];
				number[i] = number[j];
				number[j] = temp;
				DFS(i, cnt + 1);
				temp = number[i];
				number[i] = number[j];
				number[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
        	token = new StringTokenizer(br.readLine());
        	String temp = token.nextToken();
        	N = Integer.parseInt(token.nextToken());
        	result = 0;
        	
        	number = new int[temp.length()];
        	for(int i=0; i<temp.length(); i++) {
        		number[i] = temp.charAt(i) - '0';
        	}
        	
        	// 교환 기회인 N이 number.length 만큼 있으면 완전 내림차순으로 정렬 가능하므로
        	// number.length 번 이후 교환 횟수는 무의미하다.
        	// 그래서 N을 number.length로 귀결.
        	if(number.length < N) N = number.length;
        	
        	DFS(0, 0);
        	bw.write("#" + test_case + " " + result + "\n");
        	
        }
        // 3 2 8 8 8
        // 3 4 8 8 8
        bw.close();
	}
}
//10
//123 1
//2737 1
//757148 1
//78466 2
//32888 2
//777770 5
//436659 2
//431159 7
//112233 3
//456789 10