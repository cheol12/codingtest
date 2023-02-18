package Main;

import java.io.*;
import java.util.*;

public class Main2178 {
    // 문제 제목 : 미로 탐색
    // 알고리즘 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};   // 상하좌우를 탐색하기 위함
    static boolean[][] visited;
    static int[][] A;
    static int N, M;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            String line = token.nextToken();
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        bw.write(String.valueOf(A[N-1][M-1]));
        bw.close();
    }

    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});   // 이해불가
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < M){ // 배열을 넘어가면 안됨
                    if(A[x][y]!=0 && !visited[x][y]){   // 0이어서 갈 수 없거나 이미 방문해서 갈 수 없음
                        // if 조건 통과하면 갈 수 있는 곳
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y}); // 이해불가
                    }
                }
            }
        }
    }
}
