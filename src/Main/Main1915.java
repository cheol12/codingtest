package Main;

import java.util.*;
import java.io.*;

class Main1915{
    static int n,m;
    static long[][] D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        D = new long[n+1][m+1];
        long max = 0;
        // D[a][b]는
        // a행b열을 오른쪽 아래로 둔 정사각형 중 최대 정사각형의 변 길이로 표현.
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                D[i][j] = Long.parseLong(String.valueOf(temp.charAt(j)));

                // 사각형 형태 중 오른쪽 아래를 제외한 3곳을 비교.
                // 3곳 중 가장 최소값 + 1 을 한 것이,
                // D[i][j] 위치에 이르기까지 만들 수 있는 정사각형의 크기라고 할 수 있다.
                // i,j 둘 다 1이상일 때만 적용
                if(D[i][j] == 1 && !(i == 0 || j == 0))
                    D[i][j] = Math.min(D[i-1][j-1],Math.min(D[i-1][j],D[i][j-1])) + D[i][j];
                // 해당 D[i][j] 값이 증가할 때마다 갱신
                max = Math.max(max, D[i][j]);
            }
        }
        bw.write(String.valueOf(max * max));
        bw.close();
    }
}