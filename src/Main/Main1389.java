package Main;

import java.io.*;
import java.util.*;

public class Main1389 {
    // 그리디 알고리즘

    public static void main(String args[]) throws IOException{

        // 입력 : 첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다.
        // 둘째 줄부터 M개의 줄에는 친구 관계가 주어진다. 친구 관계는 A와 B로 이루어져 있으며,
        // A와 B가 친구라는 뜻이다. A와 B가 친구이면, B와 A도 친구이며, A와 B가 같은 경우는 없다.
        // 친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다. 또, 모든 사람은
        // 친구 관계로 연결되어져 있다. 사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.

        // 출력 : 첫째 줄에 BOJ의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 출력한다.
        // 그런 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] c = new int[N+1][N+1];  // 1~N까지 행렬 생성.
        ArrayList<Integer> count = new ArrayList<>();     // 해당 유저 총합

        int INF = 10000;    // 초기값으로 선택

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                // 배열 내 값 갱신을 최소값으로 하기 위해 초기값을 크게 설정.
                c[i][j] = INF;

                if( i == j ){
                    c[i][j] = 0;
                }
            }
        }

        for(int i=0; i<M; i++){     // 친구 사이 표시
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            c[a][b] = c[b][a] = 1;  // 친구 사이는 양방향
        }

        // 플로이드 와샬 알고리즘 - 모든 정점에서 모든 정점 사이의 최단 거리 탐색.
        // k = 거쳐갈 점, i = 출발점, j = 도착점
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j]);
                }
            }
        }
        // 알고리즘 반복문에서 i, j, k 순서가 아닌 k, i, j 순서를 쓰는 이유 ->
        // i가 가장 바깥 for문 이라면 한번 지나가고 난 뒤 돌아올 수 없기 때문.
        // 만일 출발점인 i를 가장 바깥 반복문으로 지정하고 진행한다면 순서가 생긴다.
        // 반복문 숫자의 순서 (i, j)는 의미가 없다.
        // 앞선 반복문에서 연결되었다고 결론 지은 관계를
        // 부정하는 경우가 생길 수 있다.

        count.add(INF); // 0인덱스에 값 채우기
        for(int i=1; i<N; i++){
            int count1 = 0;
            for(int j=1; j<N; j++){
                count1 += c[i][j];
            }
            if(){

            }
        }


        bw.write(Arrays.deepToString(c));
        bw.close();
    }

}
