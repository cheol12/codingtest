package Main;

import java.io.*;
import java.util.*;

class Main2447{
    static int N;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        DFS(N, 0, 0);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == null) bw.write(" ");
                else bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void DFS(int size, int x, int y) {
        // 최소 단위인 1로 분할되면 별 저장
        if(size == 1) {
            arr[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i == 1 && j == 1) continue;
                DFS(size/3, x + size/3 * i, y + size/3 * j);
            }
        }
    }
}
//https://lasbe.tistory.com/134