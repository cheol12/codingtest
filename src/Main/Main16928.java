package Main;

import java.util.*;
import java.io.*;

class Main16928{
    static int N,M;
    static int[] board;
    static int[] count;
    static boolean[] visited;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        board = new int[101];
        count = new int[101];
        visited = new boolean[101];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            board[x] = y;
        }

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            board[u] = v;
        }

        bfs();
        bw.close();
    }

    static void bfs() throws IOException{
        Queue<Integer> queue = new LinkedList<>();
        //현재 위치=1 을 큐에 넣는다
        queue.offer(1);
        // 위치 1에 도달할 때 필요한 주사위 횟수(최소) = 0, 출발점이기 때문
        count[1] = 0;
        visited[1] = true;    //방문 처리

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == 100){
                bw.write(count[current]+"");
                return;
            }

            // 주사위 1~6 중 가장 최선의 선택 고르기
            for(int i=1; i<=6; i++){
                int next = current + i;    // 다음위치 = 현재위치 + 주사위 1번(1~6)
                if(next > 100) break;    // 다음위치가 게임판 넘어가면 끝
                // 다음위치가 이미 방문했다면 주사위의 다른 수로 넘어가기
                if(visited[next]) continue;
                // 위 조건들에 해당하지 않는다면 방문 처리하며 반복문 시작
                visited[next] = true;

                // 다음 위치가 미리 설정해놓은 사다리 or 뱀의 위치라면
                if(board[next] != 0){
                    // + 사다리 or 뱀으로 이동할 곳이 새로 방문할 곳이라면
                    if(!visited[board[next]]){
                        //해당 위치로 이동 + 큐에 넣는다
                        queue.offer(board[next]);
                        visited[board[next]] = true;
                        count[board[next]] = count[current] + 1;
                    }
                }
                // 그냥 평범한 칸이면
                else{
                    // 해당 위치로 이동 + 큐에 넣는다
                    queue.offer(next);
                    visited[next] = true;
                    count[next] = count[current] + 1;
                }
            }
        }
    }
}
//https://settembre.tistory.com/320