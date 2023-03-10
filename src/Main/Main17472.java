package Main;

import java.io.*;
import java.util.*;

public class Main17472 {
    //구현
    //그래프 이론
    //브루트포스 알고리즘
    //그래프 탐색
    //너비 우선 탐색
    //깊이 우선 탐색
    //최소 스패닝 트리
    static int[] parent;    // 대표노드 확인
    static int N, M, sNum;  // 가로, 세로, 섬의 번호=개수
    static int[] dr = {-1, 0, 1, 0};    // 다리가 좌우로만
    static int[] dc = {0, 1, 0, -1};    // 다리가 상하로만
    static int[][] map;             // 땅 or 바다 표현
    static boolean[][] visited;     // 방문 확인(BFS로)
    static ArrayList<ArrayList<int[]>> sumlist; // 모든 섬 정보 저장
    static ArrayList<int[]> mlist;  // 1개의 섬 정보 저장
    static PriorityQueue<bEdge> queue;  // 다리 정보 저장할 우선순위 큐

    public static void main(String args[]) throws IOException {
        //입력 : 첫째 줄에 지도의 세로 크기 N, 가로 크기 M.
        //둘째 줄부터 N개의 줄에 지도의 정보가 주어짐.
        //각 줄은 M개의 수로 이루어져 있으며, 수는 0 또는 1이다.
        //0은 바다, 1은 땅을 의미한다.
        //
        //출력 : 모든 섬을 연결하는 다리 길이의 최솟값을 출력.
        //모든 섬을 연결하는 것이 불가능하면 -1 출력력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());    // 맵 가로크기
        M = Integer.parseInt(token.nextToken());    // 맵 세로크기

        map = new int[N][M];    // 빈 맵 생성
        visited = new boolean[N][M];    // 방문배열 생성
        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                // 맵 정보 저장
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        sNum = 1;   // 섬의 번호이자 개수
        sumlist = new ArrayList<>();
        // 각 자리에서 BFS 탐색을 이용해 섬들을 분리한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 맵의 해당 칸이 0이 아니고 방문하지 않았다면
                if(map[i][j] != 0 && visited[i][j] != true){
                    BFS(i,j);
                    sNum++;     // 부여할 번호 증가
                    sumlist.add(mlist);
                }
            }
        }

        queue = new PriorityQueue<>();
        // 섬의 각 지점에서 만들 수 있는 모든 간선 저장하는 반복문
        for(int i = 0; i < sumlist.size(); i++){    // 모든 섬에 적용
            ArrayList<int[]> now = sumlist.get(i);  //모든 섬 중 하나 선택
            for(int j = 0; j < now.size(); j++){    // 선택한 섬의 땅마다 이어질 수 있는 모든 다리의 경우의 수 보기
                int r = now.get(j)[0];  // 해당 섬의 땅 좌표(행)
                int c = now.get(j)[1];  // 해당 섬의 땅 좌표(열)
                int now_S = map[r][c];  // 해당 섬의 번호
                for(int d = 0; d < 4; d++){ // 다리 놓을 방향 탐색
                    int tempR = dr[d];  // 놓을 다리 방향(좌,우)
                    int tempC = dc[d];  // 놓을 다리 방향(상,하)
                    int blength = 0;    // 섬 간 거리 = 다리 길이
                    // 맵 안에 있을 때만 적용
                    while(r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                        // 땅이 같은 섬을 나타내는 값이면 간선 만들 수 없음.
                        if(map[r + tempR][c + tempC] == now_S)
                            break;  // 해당 방향으로는 만들 수 없으므로 종료
                        // 같은 섬이 아니고 + 바다가 아니고
                        else if(map[r + tempR][c + tempC] != 0) {
                            if(blength > 1) // 섬 간 거리가 1보다 크면 다리(간선)로 이어주기.
                                queue.add(new bEdge(now_S, map[r + tempR][c + tempC], blength));
                            break;  //다리로 이어주고 반복문 종료
                        }else
                            blength++;  // 바다면 다리 길이 연장.
                        if(tempR < 0) tempR--;      // 왼쪽은 계속 왼쪽으로
                        else if(tempR > 0) tempR++; // 오른쪽으로
                        else if(tempC < 0) tempC--; // 위쪽으로
                        else if(tempC > 0) tempC++; // 아래쪽으로
                    }
                }
            }
        }
        parent = new int[sNum]; // 섬=노드로 취급, 섬의 개수만큼 대표노드 배열 생성
        for(int i=0; i<parent.length; i++){ // 대표 노드 초기화
            parent[i] = i;
        }
        int useEdge = 0;    // 최소 신장 트리일때 간선 개수 = 다리 개수
        int result = 0;     // 모든 섬을 연결하는 다리 길이의 최솟값 = 출력값

        while(!queue.isEmpty()){    // 최소 신장 트리 알고리즘을 수행
            bEdge now = queue.poll();
            if(find(now.s) != find(now.e)){ // 같은 부모가 아니면 연결하기.
                union(now.s, now.e);    // 시작 섬, 끝 섬 연결하기.
                // 연결한 간선=다리의 가중치=길이 결과에 추가하기
                result = result + now.v;
                useEdge++;
            }
        }
        // 섬의 개수인 sNum=1, 왜 1로 초기값을 둔 건지 의문..
        if(useEdge == sNum - 2){
            bw.write(String.valueOf(result));
        }else{
            bw.write("-1");
        }

        bw.close();

    }

    public static int find(int a){  // find 연산 : 대표 노드 탐색
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }
    public static void union(int a, int b){
        a = find(a);    // union 연산 : 서로의 대표 노드 확인 후 연결
        b = find(b);
        if(a != b) parent[b] = a;
    }
    // BFS로 모든 땅을 방문하며 섬 번호 부여하기기.
    private static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;   // 해당 땅을 방문한 것으로 체크
        map[i][j] = sNum;   // 해당 땅에게 섬 번호 부여
        while(!queue.isEmpty()){
            int now[] = queue.poll();   // 땅의 좌표.
            int r = now[0];     // 행 값
            int c = now[1];     // 열 값
            for(int d = 0; d < 4; d++){
                int tempR = dr[d];
                int tempC = dc[d];
                // 맵 내에서 while문 반복
                while(r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M){
                    // 현재 방문한 적이 없고 바다가 아니면 같은 섬으로 취급
                    if(visited[r + tempR][c + tempC] == false && map[r + tempR][c + tempC] != 0){
                        addNode(r + tempR, c + tempC, queue);
                    }else break;
                    if(tempR < 0) tempR--;
                    else if(tempR > 0) tempR++;
                    else if(tempC < 0) tempC--;
                    else if(tempC > 0) tempC++;
                }
            }
        }
    }
    // 특정 위치를 섬 정보로 넣어주는 함수
    private static void addNode(int i, int j, Queue<int[]> queue){
        map[i][j] = sNum;   // 해당 땅에게 섬 번호 부여
        visited[i][j] = true;
        int[] temp = {i,j};
        mlist.add(temp);
        queue.add(temp);
    }

    static class bEdge implements Comparable<bEdge>{
        int s,e,v;
        bEdge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }
        // 오름차순 정렬
        @Override
        public int compareTo(bEdge o){
            return this.v - o.v;
        }
    }
}