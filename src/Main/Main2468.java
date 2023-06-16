package Main;

import java.io.*;
import java.util.*;

class Main2468{
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;   // 행 열
    static int[][] zone;   //
    static boolean[][] visited;
    static int height = 1;
    static int maxCount = 0;
    static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());

        zone = new int[N][N];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                zone[i][j] = Integer.parseInt(token.nextToken());
                if(zone[i][j] > height)
                    height = zone[i][j];
            }
        }

        // 처음엔 반복문 조건을 for( ; i<height; )로 구현해서 계속 틀렸다.
        // 기준 높이가 최대값이면 어차피 안전 영역이 0이 될 것이라서
        // i = height 일 때 반복문을 돌릴 필요가 없다고 생각했는데..
        // 틀렸던 이유를 정확히 모르겠다. 단순히 끝까지 반복하는게 원칙일까
        for(int i=1; i<=height; i++){
            maxCount = Math.max(maxCount, bfs(i));
        }
        bw.write(maxCount+"");
        bw.close();
    }

    static int bfs(int max){
        visited = new boolean[N][N];
        q = new LinkedList<>();

        // 기준 높이인 max 이하인 곳들은 전부 방문 처리
        for(int i=0; i<N; i++) {
            for(int j = 0; j < N; j++) {
                if(zone[i][j] < max) visited[i][j] = true;
                // 처음엔 여기 조건을
                // if(zone[i][j] <= max)로 구현해서 계속 틀렸다.
                // 위에서 처음으로 틀렸던 45줄 부분과 직결되는 부분.
            }
        }

        int Count = 0;  // 기준 높이가 max일 때 안전 영역의 개수를 반환

        // 아래의 반복문은 높이가 max 이하인 지점을 모두 잠기게 만들 때의
        // 안전 영역 개수를 반환.
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                // 높이가 max 이하여서 이미 방문 처리된(물에 잠긴) 영역은 생략
                // = 안전 영역일 때만 반복문 실행
                if(visited[i][j]) continue;

                Count++;    // 영역 하나에 돌입하면 카운트+1 하기

                // 반복문을 통해서 안전 영역 속 좌표들을 큐에 넣고 방문 처리한다.
                q.offer(new Point(i, j));
                visited[i][j] = true;
                
                while(!q.isEmpty()){
                    Point now = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = now.x + dx[k];
                        int ny = now.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(visited[nx][ny]) continue;
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return Count;   // 기준 높이가 max 일 때의 안전 영역의 개수 반환
    }
}

// 스스로 구현했다..!