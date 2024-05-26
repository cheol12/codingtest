package Main;

import java.io.*;

public class Main2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 오른 계단 1개라면 다음은 무조건 2개 오르기
        // 오른 계단 2개라면 다음은 상관없음
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        // 인덱스 예외 처리
        if(N >= 2) dp[2] = arr[2] + arr[1];

        for(int i=3; i<=N; i++){
            // 1칸으로 도착할 경우와 (dp[i-1] + arr[i])
            // 2칸으로 도착할 경우 중 (dp[i-2] + arr[i])
            // 더 큰 값을 dp[i]에 입력

            // 주의 : 1칸으로 도착할 경우를 따질 때
            // i-1 번째 계단은 반드시 2칸으로 도착했어야 한다.
            // 그래서 dp[i-1] -> dp[i-3] + arr[i-1] 로 변환하여
            // 연속된 3개의 계단 밟기 금지 조건을 만족
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        bw.write(dp[N] + "");
        bw.close();
    }
}