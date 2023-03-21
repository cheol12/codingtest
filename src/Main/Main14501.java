package Main;

import java.io.*;
import java.util.*;

public class Main14501 {
    // 다이나믹 프로그래밍
    // 브루트포스 알고리즘
    static int N;       // 퇴사 날 입력
    static int[] D;     // 오늘부터 상담 최대 수입
    static int[] T,P;   // 상담 기간, 받는 금액
    static ArrayList<Integer> a = new ArrayList<>();
    static int count = 0;   // 연산 횟수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        D = new int[N+2];   // 오늘부터 상담 최대 수입
        T = new int[N+1];   // 상담 일수
        P = new int[N+1];   // 상담할 시 받는 금액

        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(token.nextToken());
            P[i] = Integer.parseInt(token.nextToken());
        }

        // 탑-다운
        // 최대 수입을 N부터 거꾸로 반복하여 계산
        for(int i=N; i>0; i--){
            // i=오늘, T[i]=오늘 상담 기간, N=퇴사 전 날
            // 퇴사 전 날(=N)에 할 수 있는 상담은 1일만 가능하므로 기준을 N+1로 설정.
            if(i + T[i] > N + 1){   // = 해당 조건은 불가능한 상담
                D[i] = D[i+1];  // 처음에 D[8] = 0.
            }
            // 가능한 상담이라면,
            // 앞선 반복문에서 구한 D[i+1]일이 큰 지,
            // 오늘 상담 수입 + 오늘 상담 진행 다음 수입이 큰 지 비교(예제 입력4 참고)
            else{   // 만약 i=5라면 D[6]
                D[i] = Math.max(D[i+1], P[i] + D[i + T[i]]);
//                D[i] =P[i] + D[i + T[i]];
            }
        }
        bw.write(String.valueOf(D[1]));
        bw.close();
    }
}
