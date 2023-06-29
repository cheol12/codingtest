package Main;

import java.io.*;
import java.util.*;

class Main2630{
    static int N;
    static int[][] paper;
    static int count_white = 0;
    static int count_blue = 0;

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

        bw.write(count_white + "\n" + count_blue+"\n");
        bw.close();
    }

    // size를 점점 줄여나가는 과정을 담은 DFS를 구현하는 것이 핵심
    static void DFS(int size, int x, int y){
        if(check(size, x, y)){
            if(paper[x][y] == 0) count_white++;
            else count_blue++;
            return;
        }
        else{
            DFS(size/2, x, y);
            DFS(size/2, x, y + size/2);
            DFS(size/2, x + size/2, y);
            DFS(size/2, x + size/2, y + size/2);
        }
    }

    // 하나의 구역이 전부 같은 값으로 이루어지는지 판단하는 메소드
    static boolean check(int size, int x, int y){
        int color = paper[x][y];

        for(int i=x; i < x + size; i++){
            for(int j=y; j < y + size; j++){
                if(paper[i][j] != color) return false;
            }
        }
        return true;
    }
}
//https://st-lab.tistory.com/227
