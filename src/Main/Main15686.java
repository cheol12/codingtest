package Main;

import java.io.*;
import java.util.*;

public class Main15686 {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,M, result = Integer.MAX_VALUE;
    static int[][] city;
    // 여기에 바로 생성자 호출하면 실행 안됨. 안되는 이유는?
    static ArrayList<Point> house, chicken = new ArrayList<>();
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        city = new int[N][N];

        // 집과 치킨집의 좌표를 Point클래스 형태로 ArrayList에 저장해둔다
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(token.nextToken());

                if(city[i][j] == 1){
                    house.add(new Point(i,j));
                }else if(city[i][j] == 2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        open = new boolean[chicken.size()];

        DFS(0,0);
        bw.write(result+"");
        bw.close();
    }

    static void DFS(int start, int count){
        // if문 시작
        if(count == M){
            // sum = 모든 집 i에서의 치킨 거리의 합 = 도시의 치킨 거리
            int sum = 0;
            for(int i=0; i<house.size(); i++){
                // dist = 집 i에서 치킨집 j와의 거리
                int dist = Integer.MAX_VALUE;

                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){
                        // temp = 집 i의 치킨 거리 = dist들 중 최소값
                        int temp = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        dist = Math.min(dist, temp);
                    }
                }
                sum += dist;
            }
            // 각 DFS 안에서 구한 도시 치킨 거리인 sum 값들을 비교하며
            // 최소값 갱신
            result = Math.min(result, sum);
            return;
        }
        // if문 종료

        // 여기서 M=2로 주어졌을 때
        // DFS(0,0) 진입 - for문 0부터 시작
        // open[0] = true
        //      DFS(1,1) 진입 - for문 1부터 시작
        //      open[1] = true
        //          DFS(2,2) 진입
        //          도시 치킨 거리 반복문 실행
        //          open[0], open[1] 일 때 도시 치킨 거리 = open으로 결정한 치킨집이 0번째랑 1번째가 된다.
        //          구하면 빠져나오기
        //      open[1] = false
        //      open[2] = true일 때 ...
        // 0,1일 때 -> 0,2 일 때 -> 0,3일 때 -> 0,4... ->
        // -> 1,2일 때 -> 1,3일 때 -> 1,4 ... ->
        // 전부 구하면서 return 직전에 최소값 계속 갱신하며 return;

        // DFS(start+1, count+1)로 하면 답은 같은데 시간 초과가 난다 왜?
        // 또 DFS(i+1, count+1)로 하면 위에서 return을 안해도 실행된다
        for(int i = start; i<chicken.size(); i++){
            open[i] = true;
            DFS(i + 1, count + 1);
            open[i] = false;
        }
    }
}
//https://steady-coding.tistory.com/23