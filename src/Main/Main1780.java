package Main;

import java.io.*;
import java.util.*;

class Main1780{
    static int N;
    static int[][] paper;
    static int minusOneCount = 0;
    static int ZeroCount = 0;
    static int OneCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;

        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        DFS(N, 0, 0);
        bw.write(minusOneCount+"\n"+ZeroCount+"\n"+OneCount);
        bw.close();
    }

    static void DFS(int size, int x, int y){
        if(check(size, x, y)){
            if(paper[x][y] == -1) minusOneCount++;
            else if(paper[x][y] == 0) ZeroCount++;
            else OneCount++;
        }
        else{
            // 하나의 종이를 총 9구역으로 나눈 뒤 구역마다 다시 DFS 실행.
            DFS(size/3, x, y);
            DFS(size/3, x + size/3, y);
            DFS(size/3, x + 2*size/3, y);
            DFS(size/3, x, y + size/3);
            DFS(size/3, x + size/3, y + size/3);
            DFS(size/3, x + 2*size/3, y + size/3);
            DFS(size/3, x, y + 2*size/3);
            DFS(size/3, x + size/3, y + 2*size/3);
            DFS(size/3, x + 2*size/3, y + 2*size/3);
        }
    }

    static boolean check(int size, int x, int y){
        int temp = paper[x][y];
        for(int i=x; i<size + x; i++){
            for(int j=y; j<size + y; j++){
                //하나의 종이로 결정하는 중에 다른 값이 있다면
                if(temp != paper[i][j]) return false;
            }
        }
        // 하나의 종이로 결정
        return true;
    }
}
