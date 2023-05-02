package Main;

import java.io.*;
import java.util.*;

public class Main14500 {

    static int N, M, max = Integer.MIN_VALUE;
    static int[][] paper;
    static boolean[][] visited;

    //상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // 전체 탐색 dfs
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                solve(i,j,paper[i][j],1);
                visited[i][j] = false;
            }
        }

        bw.write(max+"");
        bw.close();
    }

    static void solve(int row, int col, int sum, int count){
        // 테트로미노 완성 시 수들의 합 계산
        if(count == 4){     // count==4인 이유: ㅜ 모양 뺀 4가지 경우 계산
            max = Math.max(max, sum);
            return;
        }
        // 상하좌우 탐색
        for(int i=0; i<4; i++){
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            // 범위 벗어나면 예외 처리
            if(curRow < 0 || curRow >= N || curCol < 0 || curCol >= M){
                continue;
            }

            // 아직 방문하지 않은 곳이면
            if(!visited[curRow][curCol]){

                // 'ㅗ'모양 테트로미노 만들기 위해 2번째 칸에서 탐색 한 번 더 진행
                if(count == 2){
                    visited[curRow][curCol] = true;
                    solve(row, col, sum + paper[curRow][curCol], count + 1);
                    visited[curRow][curCol] = false;
                }

                visited[curRow][curCol] = true;
                solve(curRow, curCol, sum + paper[curRow][curCol], count + 1);
                visited[curRow][curCol] = false;
            }
        }

    }
}