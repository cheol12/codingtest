package Main;

import java.io.*;
import java.util.*;

class Main1926{
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] board;   // 도화지판
    static int n, m;        // 가로, 세로
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};    // 좌 하 우 상
    static int[] dy = {0, 1, 0, -1};    // 좌 하 우 상
    static int count = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // 넓이 가장 넓은 것 반환
        // 그림들 총 개수 반환
        bfs();

        bw.write(count + "\n" + max);
        bw.close();
    }

    static void bfs(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] || board[i][j] == 0) continue;
                count++;    // 그림 하나
                visited[i][j] = true;   // 방문 시작

                // 하나의 그림을 구성하는 좌표들을 큐에 담는다
                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i,j));

                int area = 0;   // 넓이 나타낼 객체
                while(!q.isEmpty()){    // 하나의 그림이 끝날 때까지 넓이 판단
                    Point point = q.poll();
                    area++;

                    for(int k=0; k<4; k++){
                        int nx = point.x + dx[k];
                        int ny = point.y + dy[k];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(visited[nx][ny] || board[nx][ny] == 0) continue;

                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny)); // 다음 좌표 담기
                    }
                }
                // 하나의 넓이 판단이 끝난 뒤 이전 것들과 최대 넓이를 비교
                max = Math.max(max, area);
            }
        }
    }
}