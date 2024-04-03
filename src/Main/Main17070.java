package Main;

import java.io.*;
import java.util.*;

public class Main17070 {

    static int N;
    static int[][] house;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());

        house = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                house[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // 1. 가로 라면
        // 1-1. 오른쪽으로 밀 수 있는지
        // 1-2. 대각선으로 꺾을 수 있는지

        // 2. 대각선 이라면
        // 2-1. 오른쪽으로 꺾을 수 있는지
        // 2-2. 대각선으로 밀 수 있는지
        // 2-3. 아래로 꺾을 수 있는지

        // 3. 아래 라면
        // 3-1. 대각선으로 꺾을 수 있는지
        // 3-2. 아래로 밀 수 있는지

        DFS(1, 2, "right");

        bw.write(count + "");
        bw.close();
    }

    static void DFS(int curR, int curC, String curDirection){
        if(curR == N && curC == N){
            count++;
            return;
        }

        if(curDirection.equals("right")){
            // 오른쪽으로 밀 수 있으면
            if(curC + 1 <= N && house[curR][curC+1] == 0){
                DFS(curR, curC + 1, "right");
            }
        }
        else if(curDirection.equals("diagonal")){
            // 오른쪽으로 꺾을 수 있으면
            if(curC + 1 <= N && house[curR][curC+1] == 0){
                DFS(curR, curC + 1, "right");
            }
            // 아래로 꺾을 수 있으면
            if(curR + 1 <= N && house[curR+1][curC] == 0){
                DFS(curR + 1, curC, "under");
            }
        }
        else{
            // 아래로 밀 수 있으면
            if(curR + 1 <= N && house[curR+1][curC] == 0){
                DFS(curR + 1, curC, "under");
            }
        }

        // 대각선으로 밀 수 있으면 (방향 무관하게 공통 로직임)
        if(curR + 1 <= N && curC + 1 <= N && house[curR][curC+1] == 0 &&
                house[curR+1][curC+1] == 0 && house[curR+1][curC] == 0){
            DFS(curR + 1, curC + 1, "diagonal");
        }
    }

}
