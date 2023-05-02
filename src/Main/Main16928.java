package Main;

import java.io.*;
import java.util.*;

public class Main16928 {

    static int N,M;
    static int[] arr;
    static int[] count;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[101];
        count = new int[101];
        visited = new boolean[101];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arr[start] = end;
        }

        for(int i=0; i<M; i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            arr[start] = end;
        }

        // 매 순간 최선의 선택 = BFS
        bfs();
        bw.close();
    }

    static void bfs() throws IOException{
        // 큐 = 선입선출, 스택 = 후입선출
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        count[1] = 0;   // count[n] = n으로 이동할 수 있는 최소 주사위 횟수
        visited[1] = true;

        while(!queue.isEmpty()){
            // poll() = 해당 값 나타내고 큐 안에서는 삭제
            int current = queue.poll(); // 큐 맨 앞에 있는 값 뽑기 = 현재 위치
            if(current == 100){
                bw.write(count[current]+"");
                return;
            }

            // 현재 위치에서 주사위 굴릴 때 갈 수 있는 곳 모두 검색
            for(int i=1; i<=6; i++){
                int next = current + i; // 다음 위치
                if(next > 100) break;    // 맵 넘어가면 종료
                if(visited[next]) continue; // 이미 방문한 곳이면 패스
                visited[next] = true;   // 방문 처리 하고 검색 시작

                // 다음 위치가 미리 입력해놓은 사다리 or 뱀의 위치라면
                if(arr[next] != 0){
                    // + 사다리 or 뱀으로 인해 이동한 곳이 새로 방문한 곳이면
                    if(!visited[arr[next]]){
                        queue.offer(arr[next]); // 해당 위치를 큐에 넣는다.
                        visited[arr[next]] = true;  // 방문 처리
                        // 주사위 횟수 배열 값 증가
                        count[arr[next]] = count[current] + 1;
                    }
                }else{  // 그냥 빈 곳이면
                    queue.offer(next);
                    count[next] = count[current] + 1;
                }
            }
        }
    }
}
//https://settembre.tistory.com/320