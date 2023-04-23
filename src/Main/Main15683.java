package Main;

import java.util.*;
import java.io.*;

public class Main15683 {
    static class CCTV{
        int num,x,y;
        CCTV(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;     // 전체 사무실 크기 N행 M열, 8을 넘지 않음
    // 0 = 빈칸, 1~5 = cctv 번호, 6 = 벽
    static int[][] map; // 사무실 배열
    static int[][] copymap;   // map에 감시구역 표시
    static int[] output;    // 출력

    // 클래스로 정의한 cctv 객체를 넣을 리스트
    static ArrayList<CCTV> cctvList;
    static int[] dx = {-1,0,1,0};   // 상우하좌 이동시 좌표 변화(x)
    static int[] dy = {0,1,0,-1};   // 상우하좌 이동시 좌표 변화(y)
    static int answer = Integer.MAX_VALUE; // 사각 지대의 최소 크기

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        cctvList = new ArrayList<>();

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(token.nextToken());

                //cctv가 빈 칸도 아니고 벽도 아니면
                if(map[i][j] != 0 && map[i][j] != 6){
                    cctvList.add(new CCTV(map[i][j], i, j));
                }
            }
        }

        output = new int[cctvList.size()];  // 순열을 담을 배열
        permutation(0, cctvList.size());
        // 사각 지대의 최소 크기
        bw.write(answer+"");
        bw.close();
    }

    static void permutation(int depth, int r){
        if(depth == r){
            copymap = new int[N][M];
            for(int i=0; i<map.length; i++){
                // arraycopy(복사할것, 복사 시작 위치, 옮길 곳,
                // 옮기기 시작 위치, 복사본에서 복사할 길이)
                System.arraycopy(map[i], 0, copymap[i], 0, map[i].length);
            }

            // cctv번호와 순열로 뽑혀진 방향에 맞는 상하좌우
            for(int i=0; i<cctvList.size(); i++){
                direction(cctvList.get(i), output[i]);
            }

            // 사각 지대 구하기
            getBlindSpot();

            return;
        }

        for(int i=0; i<4; i++){     // 반복을 4로 하는 이유?
            // output의 용도? 모르겠음
            output[depth] = i;
            permutation(depth+1, r);
        }
    }

    // 각 cctv 번호, 해당 cctv가 볼 수 있는 모든 방향을 표현
    static void direction(CCTV cctv, int d){
        // direction(cctv,d)에 들어온 cctv 객체 안에 있는 num 값을
        // cctvNum으로 새로 정의한다.
        int cctvNum = cctv.num;

        if(cctvNum == 1){   // 1번 = 한 쪽만 보는 경우
            if(d == 0) watch(cctv, 0);  // 상
            else if(d == 1) watch(cctv, 1); // 우
            else if(d == 2) watch(cctv, 2); // 하
            else if(d == 3) watch(cctv, 3); // 좌
        }
        else if(cctvNum == 2){     // 2번 = 양 쪽으로 보는 경우
            if(d == 0 || d == 2){   // 상 하
                watch(cctv, 0);
                watch(cctv, 2);
            }else{                  // 좌 우
                watch(cctv, 1);
                watch(cctv, 3);
            }
        }
        else if(cctvNum == 3){     // 3번 = 수직으로 보는 경우
            if(d == 0){             // 상 우
                watch(cctv, 0);
                watch(cctv, 1);
            }else if(d == 1){       // 우 하
                watch(cctv, 1);
                watch(cctv, 2);
            }else if(d == 2){       // 하 좌
                watch(cctv, 2);
                watch(cctv, 3);
            }else if(d == 3){       // 좌 상
                watch(cctv, 3);
                watch(cctv, 0);
            }
        }
        else if(cctvNum == 4){     // 4번 = 세 방향 보는 경우
            if(d == 0){     // 좌 상 우
                watch(cctv, 3);
                watch(cctv, 0);
                watch(cctv, 1);
            }else if(d == 1){   // 상 우 하
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);

            }else if(d == 2){   // 우 하 좌
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);

            }else if(d == 3){   // 하 좌 상
                watch(cctv, 2);
                watch(cctv, 3);
                watch(cctv, 0);

            }
        }
        else if(cctvNum == 5){      // 4방향 모두 보는 경우
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }

    }

    // BFS로 감시할 수 있는 모든 경우를 구한다
    static void watch(CCTV cctv, int d){
        Queue<CCTV> queue = new LinkedList<>(); // 선입선출
        boolean[][] visited = new boolean[N][M];

        queue.add(cctv);    // cctv 객체를 큐에 넣어라

        // 임의로 cctv 감시 가능한 구역 표시
        visited[cctv.x][cctv.y] = true;

        while(!queue.isEmpty()){
            int nx = queue.peek().x + dx[d];    // peek은 확인만
            int ny = queue.poll().y + dy[d];    // poll은 확인+삭제

            // 범위를 벗어나거나 벽을 만나면 감시 표시 중단
            if(nx<0 || nx>=N || ny<0 || ny>=M || copymap[nx][ny] == 6){
                break;
            }

            // 감시 가능한 빈 칸이라면
            if(copymap[nx][ny] == 0){
                copymap[nx][ny] = -1;   // 감시 가능하다는 의미로 -1 설정
                queue.add(new CCTV(cctv.num, nx, ny));

            }else{  // 그 외 경우는 cctv의 번호이거나 이미 감시가능한 곳이기 때문에 패스
                queue.add(new CCTV(cctv.num, nx, ny));
            }
        }
    }

    static void getBlindSpot(){
        int cnt = 0;

        // 감시 가능한 곳을 전부 탐색했음에도 0으로 되어있는 곳이 사각지대
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copymap[i][j] == 0) cnt++;
            }
        }
        // copymap에서 사각지대들을 더하고
        // 사각지대가 되는 경우들 중 가장 최소값 구하기 = 문제의 최종 답
        answer = Math.min(answer, cnt);
    }
}
