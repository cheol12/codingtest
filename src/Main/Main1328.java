package Main;

import java.util.*;
import java.io.*;

class Main1328{
    static int N,L,R;
    static long[][][] building;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        building = new long[N+1][N+1][N+1];
        building[1][1][1] = 1;

        // N-1 -> N이 될 때
        // = N-1에서 맨 왼쪽에 하나가 추가되는 경우(L-1->L, R-1)
        // + N-1에서 맨 오른쪽에 하나가 추가되는 경우(R-1->R,L-1)
        // + N-1에서 그 외 사이에 하나가 추가되는 경우(=L과 R은 변함없을 것)
        // (사이에 위치할 수 있는 경우의 수 = N-2)
        for(int i=2; i<=N; i++){
            building[i][i][1] = building[i][1][i] = 1;
            for(int j=1; j<=L; j++){
                for(int k=1; k<=R; k++){
                    building[i][j][k]
                            = (building[i-1][j-1][k]
                            + building[i-1][j][k-1]
                            + building[i-1][j][k] * (i-2)) % 1000000007;
                    // 추가할 빌딩은 가장 작은 것으로 가정.
                    // building[i-1][j-1][k]에서 맨 왼쪽에 빌딩 하나를 추가하면
                    // building[i][j][k] 개수 중 일부가 된다.
                    // building[i-1][j][k-1]에서 맨 오른쪽에 추가하는 것도 마찬가지
                    // building[i][j][k] 개수 중 일부.
                    // 추가할 빌딩이 그 사이에 위치하는 경우도 추가
                    // = j,k는 영향 없음
               }
            }
        }
        bw.write(String.valueOf(building[N][L][R]));
        bw.close();
    }
}
//3차원 배열 이해 : https://blog.naver.com/oblab/150127516854
//문제 풀이 : https://loosie.tistory.com/205